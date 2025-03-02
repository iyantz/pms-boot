package com.yantz.boot.project.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import jakarta.validation.constraints.*;

/**
 * 项目信息表单对象
 *
 * @author yantz
 * @since 2025-03-02 14:04
 */
@Getter
@Setter
@Schema(description = "项目信息表单对象")
public class PmsProjectForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "项目ID")
    @NotNull(message = "项目ID不能为空")
    private Long projectId;

    @Schema(description = "项目名称")
    @NotBlank(message = "项目名称不能为空")
    @Size(max=100, message="项目名称长度不能超过100个字符")
    private String projectName;

    @Schema(description = "项目简称")
    @Size(max=100, message="项目简称长度不能超过100个字符")
    private String projectShortName;

    @Schema(description = "合同甲方")
    @Size(max=100, message="合同甲方长度不能超过100个字符")
    private String partyA;

    @Schema(description = "合同乙方")
    @Size(max=100, message="合同乙方长度不能超过100个字符")
    private String partyB;

    @Schema(description = "项目周期")
    @Size(max=20, message="项目周期长度不能超过20个字符")
    private String projectPeriod;

    @Schema(description = "项目金额")
    private BigDecimal projectAmount;

    @Schema(description = "简介")
    @Size(max=200, message="简介长度不能超过200个字符")
    private String description;

    @Schema(description = "备注")
    @Size(max=500, message="备注长度不能超过500个字符")
    private String remark;

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
