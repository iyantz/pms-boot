package com.yantz.boot.release.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 发布计划视图对象
 *
 * @author yantz
 * @since 2025-03-02 13:40
 */
@Getter
@Setter
@Schema( description = "发布计划视图对象")
public class PmsReleasePlanVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "计划ID")
    private Long planId;
    @Schema(description = "项目ID")
    private Long projectId;
    @Schema(description = "计划名称")
    private String planName;
    @Schema(description = "计划版本")
    private String planVersion;
    @Schema(description = "计划时间")
    private LocalDateTime planTime;
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
