package com.yantz.boot.task.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 任务列表视图对象
 *
 * @author yantz
 * @since 2025-03-02 13:34
 */
@Getter
@Setter
@Schema( description = "任务列表视图对象")
public class PmsTaskVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "任务ID")
    private Long taskId;
    @Schema(description = "需求ID")
    private Long requirementId;
    @Schema(description = "任务名称")
    private String taskName;
    @Schema(description = "优先级")
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
