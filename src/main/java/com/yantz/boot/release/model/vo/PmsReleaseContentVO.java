package com.yantz.boot.release.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 发布内容视图对象
 *
 * @author yantz
 * @since 2025-03-02 13:47
 */
@Getter
@Setter
@Schema( description = "发布内容视图对象")
public class PmsReleaseContentVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "内容ID")
    private Long contentId;
    @Schema(description = "发布ID")
    private Long releaseId;
    @Schema(description = "内容")
    private String content;
    @Schema(description = "文件路径")
    private String filePath;
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
