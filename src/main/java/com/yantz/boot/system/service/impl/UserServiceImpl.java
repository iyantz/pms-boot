package com.yantz.boot.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yantz.boot.common.constant.RedisConstants;
import com.yantz.boot.common.constant.SystemConstants;
import com.yantz.boot.common.exception.BusinessException;
import com.yantz.boot.common.model.Option;
import com.yantz.boot.core.security.manager.TokenManager;
import com.yantz.boot.core.security.service.PermissionService;
import com.yantz.boot.core.security.util.SecurityUtils;
import com.yantz.boot.system.converter.UserConverter;
import com.yantz.boot.system.enums.DictCodeEnum;
import com.yantz.boot.system.mapper.UserMapper;
import com.yantz.boot.system.model.bo.UserBO;
import com.yantz.boot.system.model.dto.UserAuthInfo;
import com.yantz.boot.system.model.dto.UserExportDTO;
import com.yantz.boot.system.model.entity.DictData;
import com.yantz.boot.system.model.entity.User;
import com.yantz.boot.system.model.form.*;
import com.yantz.boot.system.model.query.UserPageQuery;
import com.yantz.boot.system.model.vo.UserInfoVO;
import com.yantz.boot.system.model.vo.UserPageVO;
import com.yantz.boot.system.model.vo.UserProfileVO;
import com.yantz.boot.system.service.DictDataService;
import com.yantz.boot.system.service.RoleService;
import com.yantz.boot.system.service.UserRoleService;
import com.yantz.boot.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户业务实现类
 *
 * @author Ray.Hao
 * @since 2022/1/14
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRoleService userRoleService;

    private final RoleService roleService;

    private final PermissionService permissionService;

    private final StringRedisTemplate redisTemplate;

    private final TokenManager tokenManager;

    private final DictDataService dictDataService;

    private final UserConverter userConverter;

    /**
     * 获取用户分页列表
     *
     * @param queryParams 查询参数
     * @return {@link IPage<UserPageVO>} 用户分页列表
     */
    @Override
    public IPage<UserPageVO> getUserPage(UserPageQuery queryParams) {

        // 参数构建
        int pageNum = queryParams.getPageNum();
        int pageSize = queryParams.getPageSize();
        Page<UserBO> page = new Page<>(pageNum, pageSize);
        // 查询数据
        Page<UserBO> userPage = this.baseMapper.getUserPage(page, queryParams);

        // 实体转换
        return userConverter.toPageVo(userPage);
    }

    /**
     * 获取用户表单数据
     *
     * @param userId 用户ID
     * @return {@link UserForm} 用户表单数据
     */
    @Override
    public UserForm getUserFormData(Long userId) {
        return this.baseMapper.getUserFormData(userId);
    }

    /**
     * 新增用户
     *
     * @param userForm 用户表单对象
     * @return true|false
     */
    @Override
    public boolean saveUser(UserForm userForm) {

        String username = userForm.getUsername();

        long count = this.count(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        Assert.isTrue(count == 0, "用户名已存在");

        // 实体转换 form->entity
        User entity = userConverter.toEntity(userForm);

        // 设置默认加密密码
        String defaultEncryptPwd = passwordEncoder.encode(SystemConstants.DEFAULT_PASSWORD);
        entity.setPassword(defaultEncryptPwd);

        // 新增用户
        boolean result = this.save(entity);

        if (result) {
            // 保存用户角色
            userRoleService.saveUserRoles(entity.getId(), userForm.getRoleIds());
        }
        return result;
    }

    /**
     * 更新用户
     *
     * @param userId   用户ID
     * @param userForm 用户表单对象
     * @return true|false
     */
    @Override
    @Transactional
    public boolean updateUser(Long userId, UserForm userForm) {

        String username = userForm.getUsername();

        long count = this.count(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username)
                .ne(User::getId, userId)
        );
        Assert.isTrue(count == 0, "用户名已存在");

        // form -> entity
        User entity = userConverter.toEntity(userForm);

        // 修改用户
        boolean result = this.updateById(entity);

        if (result) {
            // 保存用户角色
            userRoleService.saveUserRoles(entity.getId(), userForm.getRoleIds());
        }
        return result;
    }

    /**
     * 删除用户
     *
     * @param idsStr 用户ID，多个以英文逗号(,)分割
     * @return true|false
     */
    @Override
    public boolean deleteUsers(String idsStr) {
        Assert.isTrue(StrUtil.isNotBlank(idsStr), "删除的用户数据为空");
        // 逻辑删除
        List<Long> ids = Arrays.stream(idsStr.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        return this.removeByIds(ids);

    }

    /**
     * 根据用户名获取认证信息
     *
     * @param username 用户名
     * @return 用户认证信息 {@link UserAuthInfo}
     */
    @Override
    public UserAuthInfo getUserAuthInfo(String username) {
        UserAuthInfo userAuthInfo = this.baseMapper.getUserAuthInfo(username);
        if (userAuthInfo != null) {
            Set<String> roles = userAuthInfo.getRoles();
            // 获取最大范围的数据权限
            Integer dataScope = roleService.getMaximumDataScope(roles);
            userAuthInfo.setDataScope(dataScope);
        }
        return userAuthInfo;
    }

    /**
     * 获取导出用户列表
     *
     * @param queryParams 查询参数
     * @return {@link List<UserExportDTO>} 导出用户列表
     */
    @Override
    public List<UserExportDTO> listExportUsers(UserPageQuery queryParams) {
        List<UserExportDTO> userExportDTOS = this.baseMapper.listExportUsers(queryParams);
        //获取角色的字典数据
        List<DictData> list = dictDataService.list(new LambdaQueryWrapper<DictData>().eq(DictData::getDictCode, DictCodeEnum.GENDER.getValue()));
        Map<String, String> genderMap = list.stream().collect(Collectors.toMap(DictData::getValue, DictData::getLabel));
        userExportDTOS.forEach(userExportDTO -> {
            String genderLabel = genderMap.get(userExportDTO.getGender());
            userExportDTO.setGender(genderLabel);
        });
        return null;
    }

    /**
     * 获取登录用户信息
     *
     * @return {@link UserInfoVO}   用户信息
     */
    @Override
    public UserInfoVO getCurrentUserInfo() {

        String username = SecurityUtils.getUsername();

        // 获取登录用户基础信息
        User user = this.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username)
                .select(
                        User::getId,
                        User::getUsername,
                        User::getNickname,
                        User::getAvatar
                )
        );
        // entity->VO
        UserInfoVO userInfoVO = userConverter.toUserInfoVo(user);

        // 用户角色集合
        Set<String> roles = SecurityUtils.getRoles();
        userInfoVO.setRoles(roles);

        // 用户权限集合
        if (CollectionUtil.isNotEmpty(roles)) {
            Set<String> perms = permissionService.getRolePermsFormCache(roles);
            userInfoVO.setPerms(perms);
        }
        return userInfoVO;
    }

    /**
     * 获取个人中心用户信息
     *
     * @param userId 用户ID
     * @return {@link UserProfileVO} 个人中心用户信息
     */
    @Override
    public UserProfileVO getUserProfile(Long userId) {
        UserBO entity = this.baseMapper.getUserProfile(userId);
        return userConverter.toProfileVO(entity);
    }

    /**
     * 修改个人中心用户信息
     *
     * @param formData 表单数据
     * @return true|false
     */
    @Override
    public boolean updateUserProfile(UserProfileForm formData) {
        Long userId = SecurityUtils.getUserId();
        User entity = userConverter.toEntity(formData);
        entity.setId(userId);
        return this.updateById(entity);
    }


    /**
     * 修改用户密码
     *
     * @param userId 用户ID
     * @param data   密码修改表单数据
     * @return true|false
     */
    @Override
    public boolean changePassword(Long userId, PasswordUpdateForm data) {

        User user = this.getById(userId);
        if (user == null) {
            throw new BusinessException("用户不存在");
        }

        String oldPassword = data.getOldPassword();

        // 校验原密码
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new BusinessException("原密码错误");
        }
        // 新旧密码不能相同
        if (passwordEncoder.matches(data.getNewPassword(), user.getPassword())) {
            throw new BusinessException("新密码不能与原密码相同");
        }

        String newPassword = data.getNewPassword();
        boolean result = this.update(new LambdaUpdateWrapper<User>()
                .eq(User::getId, userId)
                .set(User::getPassword, passwordEncoder.encode(newPassword))
        );

        if (result) {
            // 加入黑名单，重新登录
            String accessToken = SecurityUtils.getTokenFromRequest();
            tokenManager.blacklistToken(accessToken);
        }
        return result;
    }

    /**
     * 重置密码
     *
     * @param userId   用户ID
     * @param password 密码重置表单数据
     * @return true|false
     */
    @Override
    public boolean resetPassword(Long userId, String password) {
        return this.update(new LambdaUpdateWrapper<User>()
                .eq(User::getId, userId)
                .set(User::getPassword, passwordEncoder.encode(password))
        );
    }

    /**
     * 绑定或更换手机号
     *
     * @param form 表单数据
     * @return true|false
     */
    @Override
    public boolean bindOrChangeMobile(MobileUpdateForm form) {

        Long currentUserId = SecurityUtils.getUserId();
        User currentUser = this.getById(currentUserId);

        if (currentUser == null) {
            throw new BusinessException("用户不存在");
        }

        // 校验验证码
        String inputVerifyCode = form.getCode();
        String mobile = form.getMobile();

        String redisCacheKey = RedisConstants.SMS_CHANGE_CODE_PREFIX + mobile;
        String cachedVerifyCode = redisTemplate.opsForValue().get(redisCacheKey);

        if (StrUtil.isBlank(cachedVerifyCode)) {
            throw new BusinessException("验证码已过期");
        }
        if (!inputVerifyCode.equals(cachedVerifyCode)) {
            throw new BusinessException("验证码错误");
        }
        // 验证完成删除验证码
        redisTemplate.delete(redisCacheKey);

        // 更新手机号码
        return this.update(
                new LambdaUpdateWrapper<User>()
                        .eq(User::getId, currentUserId)
                        .set(User::getMobile, mobile)
        );
    }

    /**
     * 修改当前用户邮箱
     *
     * @param form 表单数据
     * @return true|false
     */
    @Override
    public boolean bindOrChangeEmail(EmailUpdateForm form) {

        Long currentUserId = SecurityUtils.getUserId();

        User currentUser = this.getById(currentUserId);
        if (currentUser == null) {
            throw new BusinessException("用户不存在");
        }

        // 获取前端输入的验证码
        String inputVerifyCode = form.getCode();

        // 获取缓存的验证码
        String email = form.getEmail();
        String redisCacheKey = RedisConstants.EMAIL_CHANGE_CODE_PREFIX + email;
        String cachedVerifyCode = redisTemplate.opsForValue().get(redisCacheKey);

        if (StrUtil.isBlank(cachedVerifyCode)) {
            throw new BusinessException("验证码已过期");
        }

        if (!inputVerifyCode.equals(cachedVerifyCode)) {
            throw new BusinessException("验证码错误");
        }
        // 验证完成删除验证码
        redisTemplate.delete(redisCacheKey);

        // 更新邮箱地址
        return this.update(
                new LambdaUpdateWrapper<User>()
                        .eq(User::getId, currentUserId)
                        .set(User::getEmail, email)
        );
    }

    /**
     * 获取用户选项列表
     *
     * @return {@link List<Option<String>>} 用户选项列表
     */
    @Override
    public List<Option<String>> listUserOptions() {
        List<User> list = this.list(new LambdaQueryWrapper<User>()
                .eq(User::getStatus, 1)
        );
        return userConverter.toOptions(list);
    }

}
