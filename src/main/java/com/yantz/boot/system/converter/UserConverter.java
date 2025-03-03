package com.yantz.boot.system.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.common.model.Option;
import com.yantz.boot.system.model.bo.UserBO;
import com.yantz.boot.system.model.dto.UserImportDTO;
import com.yantz.boot.system.model.entity.User;
import com.yantz.boot.system.model.form.UserForm;
import com.yantz.boot.system.model.form.UserProfileForm;
import com.yantz.boot.system.model.vo.UserInfoVO;
import com.yantz.boot.system.model.vo.UserPageVO;
import com.yantz.boot.system.model.vo.UserProfileVO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * 用户对象转换器
 *
 * @author Ray.Hao
 * @since 2022/6/8
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

    UserPageVO toPageVo(UserBO bo);

    Page<UserPageVO> toPageVo(Page<UserBO> bo);

    UserForm toForm(User entity);

    @InheritInverseConfiguration(name = "toForm")
    User toEntity(UserForm entity);

    @Mappings({
            @Mapping(target = "userId", source = "id")
    })
    UserInfoVO toUserInfoVo(User entity);

    User toEntity(UserImportDTO vo);


    UserProfileVO toProfileVO(UserBO bo);

    User toEntity(UserProfileForm formData);

    @Mappings({
            @Mapping(target = "label", source = "nickname"),
            @Mapping(target = "value", source = "id")
    })
    Option<String> toOption(User entity);

    List<Option<String>> toOptions(List<User> list);
}
