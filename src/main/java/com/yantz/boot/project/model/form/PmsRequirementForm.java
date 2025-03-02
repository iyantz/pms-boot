package com.yantz.boot.project.model.form;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import jakarta.validation.constraints.*;

/**
 * 需求信息表单对象
 *
 * @author yantz
 * @since 2025-03-02 13:22
 */
@Getter
@Setter
@Schema(description = "需求信息表单对象")
public class PmsRequirementForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "项目ID")
    private Long projectId;

    @Schema(description = "需求名称")
    @Size(max=100, message="需求名称长度不能超过100个字符")
    private String requirementName;

    @Schema(description = "需求提出人")
    @Size(max=100, message="需求提出人长度不能超过100个字符")
    private String proposer;

    @Schema(description = "需求提出时间")
    private LocalDateTime proposeTime;

    @Schema(description = "预计完成时间")
    private LocalDateTime expectFinishTime;

    @Schema(description = "完成状态")
    private Integer status;

    @Schema(description = "描述")
    @Size(max=200, message="描述长度不能超过200个字符")
    private String description;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;


}
