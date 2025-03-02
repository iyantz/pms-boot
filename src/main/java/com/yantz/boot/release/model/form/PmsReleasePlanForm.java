package com.yantz.boot.release.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import jakarta.validation.constraints.*;

/**
 * 发布计划表单对象
 *
 * @author yantz
 * @since 2025-03-02 13:40
 */
@Getter
@Setter
@Schema(description = "发布计划表单对象")
public class PmsReleasePlanForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "计划ID")
    @NotNull(message = "计划ID不能为空")
    private Long planId;

    @Schema(description = "项目ID")
    private Long projectId;

    @Schema(description = "计划名称")
    @Size(max=100, message="计划名称长度不能超过100个字符")
    private String planName;

    @Schema(description = "计划版本")
    @Size(max=20, message="计划版本长度不能超过20个字符")
    private String planVersion;

    @Schema(description = "计划时间")
    private LocalDateTime planTime;

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
