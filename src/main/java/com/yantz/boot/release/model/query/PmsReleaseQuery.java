package com.yantz.boot.release.model.query;

import com.yantz.boot.common.base.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 发布列表分页查询对象
 *
 * @author yantz
 * @since 2025-03-02 13:44
 */
@Schema(description ="发布列表查询对象")
@Getter
@Setter
public class PmsReleaseQuery extends BasePageQuery {

}
