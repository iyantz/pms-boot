package com.yantz.boot.project.model.query;

import com.yantz.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 需求信息分页查询对象
 *
 * @author yantz
 * @since 2025-03-02 13:22
 */
@Schema(description ="需求信息查询对象")
@Getter
@Setter
public class PmsRequirementQuery extends BasePageQuery {

}
