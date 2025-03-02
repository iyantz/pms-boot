package com.yantz.boot.release.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.release.model.entity.PmsRelease;
import com.yantz.boot.release.model.form.PmsReleaseForm;

/**
 * 发布列表对象转换器
 *
 * @author yantz
 * @since 2025-03-02 13:44
 */
@Mapper(componentModel = "spring")
public interface PmsReleaseConverter{

    PmsReleaseForm toForm(PmsRelease entity);

    PmsRelease toEntity(PmsReleaseForm formData);
}