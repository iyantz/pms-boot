package com.yantz.boot.task.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 缺陷管理视图对象
 *
 * @author yantz
 * @since 2025-03-02 13:31
 */
@Getter
@Setter
@Schema( description = "缺陷管理视图对象")
public class PmsDefectVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "缺陷ID")
    private Long defectId;
    @Schema(description = "项目ID")
    private Long projectId;
    @Schema(description = "缺陷名称")
    private String defectName;
    @Schema(description = "缺陷提出人")
    private String proposer;
    @Schema(description = "缺陷修复人")
    private String fixer;
    @Schema(description = "缺陷提出时间")
    private LocalDateTime proposeTime;
    @Schema(description = "缺陷修复时间")
    private LocalDateTime fixTime;
    @Schema(description = "缺陷修复状态")
    private String fixStatus;
    @Schema(description = "缺陷优先级")
    private String priority;
    @Schema(description = "缺陷类型")
    private String defectType;
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
