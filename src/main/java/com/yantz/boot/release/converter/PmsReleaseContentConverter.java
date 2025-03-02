package com.yantz.boot.release.converter;

import org.mapstruct.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.release.model.entity.PmsReleaseContent;
import com.yantz.boot.release.model.form.PmsReleaseContentForm;

/**
 * 发布内容对象转换器
 *
 * @author yantz
 * @since 2025-03-02 13:47
 */
@Mapper(componentModel = "spring")
public interface PmsReleaseContentConverter{

    PmsReleaseContentForm toForm(PmsReleaseContent entity);

    PmsReleaseContent toEntity(PmsReleaseContentForm formData);
}