package com.yantz.boot.project.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.project.model.entity.PmsRequirement;
import com.yantz.boot.project.model.form.PmsRequirementForm;

/**
 * 需求信息对象转换器
 *
 * @author yantz
 * @since 2025-03-02 13:22
 */
@Mapper(componentModel = "spring")
public interface PmsRequirementConverter{

    PmsRequirementForm toForm(PmsRequirement entity);

    PmsRequirement toEntity(PmsRequirementForm formData);
}