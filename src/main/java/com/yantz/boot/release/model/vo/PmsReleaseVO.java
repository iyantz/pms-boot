package com.yantz.boot.release.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 发布列表视图对象
 *
 * @author yantz
 * @since 2025-03-02 13:44
 */
@Getter
@Setter
@Schema( description = "发布列表视图对象")
public class PmsReleaseVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "发布ID")
    private Long releaseId;
    @Schema(description = "项目ID")
    private Long projectId;
    @Schema(description = "计划版本")
    private String planVersion;
    @Schema(description = "发布模块")
    private String releaseModule;
    @Schema(description = "发布时间")
    private LocalDateTime releaseTime;
    @Schema(description = "描述")
    private String description;
    @Schema(description = "创建人ID")
    private Long createBy;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新人ID")
    private Long updateBy;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
    @Schema(description = "是否删除（0: 未删除, 1: 已删除）")
    private Integer isDeleted;
}
