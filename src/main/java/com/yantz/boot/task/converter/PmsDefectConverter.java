package com.yantz.boot.task.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.task.model.entity.PmsDefect;
import com.yantz.boot.task.model.form.PmsDefectForm;

/**
 * 缺陷管理对象转换器
 *
 * @author yantz
 * @since 2025-03-02 13:31
 */
@Mapper(componentModel = "spring")
public interface PmsDefectConverter{

    PmsDefectForm toForm(PmsDefect entity);

    PmsDefect toEntity(PmsDefectForm formData);
}