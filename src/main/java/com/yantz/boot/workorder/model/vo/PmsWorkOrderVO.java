package com.yantz.boot.workorder.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 工单列表视图对象
 *
 * @author yantz
 * @since 2025-03-02 13:37
 */
@Getter
@Setter
@Schema( description = "工单列表视图对象")
public class PmsWorkOrderVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "工单ID")
    private Long workOrderId;
    @Schema(description = "项目ID")
    private Long projectId;
    @Schema(description = "需求ID")
    private Long requirementId;
    @Schema(description = "工单标题")
    private String title;
    @Schema(description = "工单描述")
    private String description;
    @Schema(description = "指定处理人ID")
    private Long handlerId;
    @Schema(description = "处理时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime handlerTime;
    @Schema(description = "优先级（1低 2中 3高）")
    private String priority;
    @Schema(description = "工单状态（0待处理 1处理中 2已处理）")
    private String status;
    @Schema(description = "创建人ID")
    private Long createBy;
    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @Schema(description = "更新人ID")
    private Long updateBy;
    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    @Schema(description = "是否删除（0: 未删除, 1: 已删除）")
    private Integer isDeleted;
}
