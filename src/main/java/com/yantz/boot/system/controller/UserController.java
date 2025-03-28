package com.yantz.boot.system.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yantz.boot.common.annotation.Log;
import com.yantz.boot.common.annotation.RepeatSubmit;
import com.yantz.boot.common.enums.LogModuleEnum;
import com.yantz.boot.common.model.Option;
import com.yantz.boot.common.result.ExcelResult;
import com.yantz.boot.common.result.PageResult;
import com.yantz.boot.common.result.Result;
import com.yantz.boot.common.util.ExcelUtils;
import com.yantz.boot.core.security.util.SecurityUtils;
import com.yantz.boot.system.listener.UserImportListener;
import com.yantz.boot.system.model.dto.UserExportDTO;
import com.yantz.boot.system.model.dto.UserImportDTO;
import com.yantz.boot.system.model.entity.User;
import com.yantz.boot.system.model.form.*;
import com.yantz.boot.system.model.query.UserPageQuery;
import com.yantz.boot.system.model.vo.UserInfoVO;
import com.yantz.boot.system.model.vo.UserPageVO;
import com.yantz.boot.system.model.vo.UserProfileVO;
import com.yantz.boot.system.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 用户控制层
 *
 * @author Ray.Hao
 * @since 2022/10/16
 */
@Tag(name = "02.用户接口")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "用户分页列表")
    @GetMapping("/page")
    @Log(value = "用户分页列表", module = LogModuleEnum.USER)
    public PageResult<UserPageVO> getUserPage(
            @Valid UserPageQuery queryParams
    ) {
        IPage<UserPageVO> result = userService.getUserPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增用户")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('sys:user:add')")
    @RepeatSubmit
    @Log(value = "新增用户", module = LogModuleEnum.USER)
    public Result<?> saveUser(
            @RequestBody @Valid UserForm userForm
    ) {
        boolean result = userService.saveUser(userForm);
        return Result.judge(result);
    }

    @Operation(summary = "用户表单数据")
    @GetMapping("/{userId}/form")
    @Log(value = "用户表单数据", module = LogModuleEnum.USER)
    public Result<UserForm> getUserForm(
            @Parameter(description = "用户ID") @PathVariable Long userId
    ) {
        UserForm formData = userService.getUserFormData(userId);
        return Result.success(formData);
    }

    @Operation(summary = "修改用户")
    @PutMapping(value = "/{userId}")
    @PreAuthorize("@ss.hasPerm('sys:user:edit')")
    @Log(value = "修改用户", module = LogModuleEnum.USER)
    public Result<Void> updateUser(
            @Parameter(description = "用户ID") @PathVariable Long userId,
            @RequestBody @Valid UserForm userForm
    ) {
        boolean result = userService.updateUser(userId, userForm);
        return Result.judge(result);
    }

    @Operation(summary = "删除用户")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('sys:user:delete')")
    @Log(value = "删除用户", module = LogModuleEnum.USER)
    public Result<Void> deleteUsers(
            @Parameter(description = "用户ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = userService.deleteUsers(ids);
        return Result.judge(result);
    }

    @Operation(summary = "修改用户状态")
    @PatchMapping(value = "/{userId}/status")
    @Log(value = "修改用户状态", module = LogModuleEnum.USER)
    public Result<Void> updateUserStatus(
            @Parameter(description = "用户ID") @PathVariable Long userId,
            @Parameter(description = "用户状态(1:启用;0:禁用)") @RequestParam Integer status
    ) {
        boolean result = userService.update(new LambdaUpdateWrapper<User>()
                .eq(User::getId, userId)
                .set(User::getStatus, status)
        );
        return Result.judge(result);
    }

    @Operation(summary = "获取当前登录用户信息")
    @GetMapping("/me")
    @Log(value = "获取当前登录用户信息", module = LogModuleEnum.USER)
    public Result<UserInfoVO> getCurrentUserInfo() {
        UserInfoVO userInfoVO = userService.getCurrentUserInfo();
        return Result.success(userInfoVO);
    }

    @Operation(summary = "用户导入模板下载")
    @GetMapping("/template")
    @Log(value = "用户导入模板下载", module = LogModuleEnum.USER)
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        String fileName = "用户导入模板.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String fileClassPath = "templates" + File.separator + "excel" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        ServletOutputStream outputStream = response.getOutputStream();
        ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build();

        excelWriter.finish();
    }

    @Operation(summary = "导入用户")
    @PostMapping("/import")
    @Log(value = "导入用户", module = LogModuleEnum.USER)
    public Result<ExcelResult> importUsers(MultipartFile file) throws IOException {
        UserImportListener listener = new UserImportListener();
        ExcelUtils.importExcel(file.getInputStream(), UserImportDTO.class, listener);
        return Result.success(listener.getExcelResult());
    }

    @Operation(summary = "导出用户")
    @GetMapping("/export")
    @Log(value = "导出用户", module = LogModuleEnum.USER)
    public void exportUsers(UserPageQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "用户列表.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        List<UserExportDTO> exportUserList = userService.listExportUsers(queryParams);
        EasyExcel.write(response.getOutputStream(), UserExportDTO.class).sheet("用户列表")
                .doWrite(exportUserList);
    }

    @Operation(summary = "获取个人中心用户信息")
    @GetMapping("/profile")
    @Log(value = "获取个人中心用户信息", module = LogModuleEnum.USER)
    public Result<UserProfileVO> getUserProfile() {
        Long userId = SecurityUtils.getUserId();
        UserProfileVO userProfile = userService.getUserProfile(userId);
        return Result.success(userProfile);
    }

    @Operation(summary = "个人中心修改用户信息")
    @PutMapping("/profile")
    @Log(value = "个人中心修改用户信息", module = LogModuleEnum.USER)
    public Result<?> updateUserProfile(@RequestBody UserProfileForm formData) {
        boolean result = userService.updateUserProfile(formData);
        return Result.judge(result);
    }

    @Operation(summary = "重置用户密码")
    @PutMapping(value = "/{userId}/password/reset")
    @PreAuthorize("@ss.hasPerm('sys:user:password:reset')")
    public Result<?> resetPassword(
            @Parameter(description = "用户ID") @PathVariable Long userId,
            @RequestParam String password
    ) {
        boolean result = userService.resetPassword(userId, password);
        return Result.judge(result);
    }

    @Operation(summary = "修改密码")
    @PutMapping(value = "/password")
    public Result<?> changePassword(
            @RequestBody PasswordUpdateForm data
    ) {
        Long currUserId = SecurityUtils.getUserId();
        boolean result = userService.changePassword(currUserId, data);
        return Result.judge(result);
    }


    @Operation(summary = "绑定或更换手机号")
    @PutMapping(value = "/mobile")
    public Result<?> bindOrChangeMobile(
            @RequestBody @Validated MobileUpdateForm data
    ) {
        boolean result = userService.bindOrChangeMobile(data);
        return Result.judge(result);
    }

    @Operation(summary = "绑定或更换邮箱")
    @PutMapping(value = "/email")
    public Result<?> bindOrChangeEmail(
            @RequestBody @Validated EmailUpdateForm data
    ) {
        boolean result = userService.bindOrChangeEmail(data);
        return Result.judge(result);
    }

    @Operation(summary = "用户下拉选项")
    @GetMapping("/options")
    public Result<List<Option<String>>> listUserOptions() {
        List<Option<String>> list = userService.listUserOptions();
        return Result.success(list);
    }
}
