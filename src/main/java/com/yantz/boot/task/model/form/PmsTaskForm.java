package com.yantz.boot.task.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import jakarta.validation.constraints.*;

/**
 * 任务列表表单对象
 *
 * @author yantz
 * @since 2025-03-02 13:34
 */
@Getter
@Setter
@Schema(description = "任务列表表单对象")
public class PmsTaskForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "任务ID")
    @NotNull(message = "任务ID不能为空")
    private Long taskId;

    @Schema(description = "需求ID")
    private Long requirementId;

    @Schema(description = "任务名称")
    @Size(max=100, message="任务名称长度不能超过100个字符")
    private String taskName;

    @Schema(description = "优先级")
    @Size(max=1, message="优先级长度不能超过1个字符")
    private String priority;

    @Schema(description = "预计开始时间")
    private LocalDateTime expectStartTime;

    @Schema(description = "预计完成时间")
    private LocalDateTime expectFinishTime;

    @Schema(description = "完成状态")
    private Integer status;

    @Schema(description = "实际开始时间")
    private LocalDateTime actualStartTime;

    @Schema(description = "实际完成时间")
    private LocalDateTime actualFinishTime;

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
