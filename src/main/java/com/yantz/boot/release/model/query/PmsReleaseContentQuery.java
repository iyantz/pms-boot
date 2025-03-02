package com.yantz.boot.release.model.query;

import com.yantz.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 发布内容分页查询对象
 *
 * @author yantz
 * @since 2025-03-02 13:47
 */
@Schema(description ="发布内容查询对象")
@Getter
@Setter
public class PmsReleaseContentQuery extends BasePageQuery {

}
