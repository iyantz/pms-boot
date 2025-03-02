package com.yantz.boot.task.model.query;

import com.yantz.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 缺陷管理分页查询对象
 *
 * @author yantz
 * @since 2025-03-02 13:31
 */
@Schema(description ="缺陷管理查询对象")
@Getter
@Setter
public class PmsDefectQuery extends BasePageQuery {

}
