package com.yantz.boot.task.model.query;

import com.yantz.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 任务列表分页查询对象
 *
 * @author yantz
 * @since 2025-03-02 13:34
 */
@Schema(description ="任务列表查询对象")
@Getter
@Setter
public class PmsTaskQuery extends BasePageQuery {

}
