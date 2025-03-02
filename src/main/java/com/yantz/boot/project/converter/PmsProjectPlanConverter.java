package com.yantz.boot.project.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.project.model.entity.PmsProjectPlan;
import com.yantz.boot.project.model.form.PmsProjectPlanForm;

/**
 * 项目计划对象转换器
 *
 * @author yantz
 * @since 2025-03-02 14:02
 */
@Mapper(componentModel = "spring")
public interface PmsProjectPlanConverter{

    PmsProjectPlanForm toForm(PmsProjectPlan entity);

    PmsProjectPlan toEntity(PmsProjectPlanForm formData);
}