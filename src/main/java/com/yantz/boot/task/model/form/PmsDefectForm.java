package com.yantz.boot.task.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import jakarta.validation.constraints.*;

/**
 * 缺陷管理表单对象
 *
 * @author yantz
 * @since 2025-03-02 13:31
 */
@Getter
@Setter
@Schema(description = "缺陷管理表单对象")
public class PmsDefectForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "缺陷ID")
    @NotNull(message = "缺陷ID不能为空")
    private Long defectId;

    @Schema(description = "项目ID")
    @NotNull(message = "项目ID不能为空")
    private Long projectId;

    @Schema(description = "缺陷名称")
    @Size(max=100, message="缺陷名称长度不能超过100个字符")
    private String defectName;

    @Schema(description = "缺陷提出人")
    @Size(max=20, message="缺陷提出人长度不能超过20个字符")
    private String proposer;

    @Schema(description = "缺陷修复人")
    @Size(max=20, message="缺陷修复人长度不能超过20个字符")
    private String fixer;

    @Schema(description = "缺陷提出时间")
    private LocalDateTime proposeTime;

    @Schema(description = "缺陷修复时间")
    private LocalDateTime fixTime;

    @Schema(description = "缺陷修复状态")
    @Size(max=1, message="缺陷修复状态长度不能超过1个字符")
    private String fixStatus;

    @Schema(description = "缺陷优先级")
    @Size(max=1, message="缺陷优先级长度不能超过1个字符")
    private String priority;

    @Schema(description = "缺陷类型")
    @Size(max=1, message="缺陷类型长度不能超过1个字符")
    private String defectType;

    @Schema(description = "描述")
    @Size(max=200, message="描述长度不能超过200个字符")
    private String description;

    @Schema(description = "创建人ID")
    @NotNull(message = "创建人ID不能为空")
    private Long createBy;

    @Schema(description = "创建时间")
    @NotNull(message = "创建时间不能为空")
    private LocalDateTime createTime;

    @Schema(description = "更新人ID")
    private Long updateBy;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "是否删除（0: 未删除, 1: 已删除）")
    private Integer isDeleted;


}
