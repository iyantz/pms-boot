package com.yantz.boot.release.converter;

import com.yantz.boot.release.model.entity.PmsReleasePlan;
import com.yantz.boot.release.model.form.PmsReleasePlanForm;
import org.mapstruct.Mapper;

/**
 * 发布计划对象转换器
 *
 * @author yantz
 * @since 2025-03-02 13:40
 */
@Mapper(componentModel = "spring")
public interface PmsReleasePlanConverter{

    PmsReleasePlanForm toForm(PmsReleasePlan entity);

    PmsReleasePlan toEntity(PmsReleasePlanForm formData);
}