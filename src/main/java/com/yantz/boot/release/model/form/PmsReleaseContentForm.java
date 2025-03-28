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
 * 发布内容表单对象
 *
 * @author yantz
 * @since 2025-03-02 13:47
 */
@Getter
@Setter
@Schema(description = "发布内容表单对象")
public class PmsReleaseContentForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "内容ID")
    @NotNull(message = "内容ID不能为空")
    private Long contentId;

    @Schema(description = "发布ID")
    private Long releaseId;

    @Schema(description = "内容")
    @Size(max=200, message="内容长度不能超过200个字符")
    private String content;

    @Schema(description = "文件路径")
    @Size(max=200, message="文件路径长度不能超过200个字符")
    private String filePath;

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
