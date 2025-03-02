package com.yantz.boot.workorder.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import jakarta.validation.constraints.*;

/**
 * 工单列表表单对象
 *
 * @author yantz
 * @since 2025-03-02 13:37
 */
@Getter
@Setter
@Schema(description = "工单列表表单对象")
public class PmsWorkOrderForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "工单ID")
    @NotNull(message = "工单ID不能为空")
    private Long workOrderId;

    @Schema(description = "项目ID")
    private Long projectId;

    @Schema(description = "需求ID")
    private Long requirementId;

    @Schema(description = "工单标题")
    @NotBlank(message = "工单标题不能为空")
    @Size(max=200, message="工单标题长度不能超过200个字符")
    private String title;

    @Schema(description = "工单描述")
    @Size(max=65535, message="工单描述长度不能超过65535个字符")
    private String description;

    @Schema(description = "指定处理人ID")
    private Long handlerId;

    @Schema(description = "处理时间")
    private LocalDateTime handlerTime;

    @Schema(description = "优先级（1低 2中 3高）")
    @Size(max=1, message="优先级（1低 2中 3高）长度不能超过1个字符")
    private String priority;

    @Schema(description = "工单状态（0待处理 1处理中 2已处理）")
    @Size(max=1, message="工单状态（0待处理 1处理中 2已处理）长度不能超过1个字符")
    private String status;

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
