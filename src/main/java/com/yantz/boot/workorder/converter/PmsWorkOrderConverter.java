package com.yantz.boot.workorder.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.workorder.model.entity.PmsWorkOrder;
import com.yantz.boot.workorder.model.form.PmsWorkOrderForm;

/**
 * 工单列表对象转换器
 *
 * @author yantz
 * @since 2025-03-02 13:37
 */
@Mapper(componentModel = "spring")
public interface PmsWorkOrderConverter{

    PmsWorkOrderForm toForm(PmsWorkOrder entity);

    PmsWorkOrder toEntity(PmsWorkOrderForm formData);
}