package com.yantz.boot.release.model.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 发布列表表单对象
 *
 * @author yantz
 * @since 2025-03-02 13:44
 */
@Getter
@Setter
@Schema(description = "发布列表表单对象")
public class PmsReleaseForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "发布ID")
    @NotNull(message = "发布ID不能为空")
    private Long releaseId;

    @Schema(description = "项目ID")
    private Long projectId;

    @Schema(description = "计划版本")
    @Size(max=20, message="计划版本长度不能超过20个字符")
    private String planVersion;

    @Schema(description = "发布模块")
    @Size(max=1, message="发布模块长度不能超过1个字符")
    private String releaseModule;

    @Schema(description = "发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime releaseTime;

    @Schema(description = "描述")
    @Size(max=200, message="描述长度不能超过200个字符")
    private String description;

    @Schema(description = "创建人ID")
    @NotNull(message = "创建人ID不能为空")
    private Long createBy;

    @Schema(description = "创建时间")
    @NotNull(message = "创建时间不能为空")
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
