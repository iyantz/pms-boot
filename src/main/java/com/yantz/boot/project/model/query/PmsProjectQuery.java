package com.yantz.boot.project.model.query;

import com.yantz.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.math.BigDecimal;

/**
 * 项目信息分页查询对象
 *
 * @author yantz
 * @since 2025-03-02 14:04
 */
@Schema(description ="项目信息查询对象")
@Getter
@Setter
public class PmsProjectQuery extends BasePageQuery {

}
