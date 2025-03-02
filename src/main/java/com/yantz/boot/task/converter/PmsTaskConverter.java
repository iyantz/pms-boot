package com.yantz.boot.task.converter;

import com.yantz.boot.task.model.entity.PmsTask;
import com.yantz.boot.task.model.form.PmsTaskForm;
import org.mapstruct.Mapper;

/**
 * 任务列表对象转换器
 *
 * @author yantz
 * @since 2025-03-02 13:34
 */
@Mapper(componentModel = "spring")
public interface PmsTaskConverter{

    PmsTaskForm toForm(PmsTask entity);

    PmsTask toEntity(PmsTaskForm formData);
}