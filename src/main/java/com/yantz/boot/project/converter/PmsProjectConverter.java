package com.yantz.boot.project.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.project.model.entity.PmsProject;
import com.yantz.boot.project.model.form.PmsProjectForm;

/**
 * 项目信息对象转换器
 *
 * @author yantz
 * @since 2025-03-02 14:04
 */
@Mapper(componentModel = "spring")
public interface PmsProjectConverter{

    PmsProjectForm toForm(PmsProject entity);

    PmsProject toEntity(PmsProjectForm formData);
}