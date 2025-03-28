package com.yantz.boot.project.model.query;

import com.yantz.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 项目计划分页查询对象
 *
 * @author yantz
 * @since 2025-03-02 14:02
 */
@Schema(description ="项目计划查询对象")
@Getter
@Setter
public class PmsProjectPlanQuery extends BasePageQuery {

}
