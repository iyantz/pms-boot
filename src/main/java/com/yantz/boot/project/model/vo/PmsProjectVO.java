package com.yantz.boot.project.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 项目信息视图对象
 *
 * @author yantz
 * @since 2025-03-02 14:04
 */
@Getter
@Setter
@Schema( description = "项目信息视图对象")
public class PmsProjectVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "项目ID")
    private Long projectId;
    @Schema(description = "项目名称")
    private String projectName;
    @Schema(description = "项目简称")
    private String projectShortName;
    @Schema(description = "合同甲方")
    private String partyA;
    @Schema(description = "合同乙方")
    private String partyB;
    @Schema(description = "项目周期")
    private String projectPeriod;
    @Schema(description = "项目金额")
    private BigDecimal projectAmount;
    @Schema(description = "简介")
    private String description;
    @Schema(description = "备注")
    private String remark;
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
