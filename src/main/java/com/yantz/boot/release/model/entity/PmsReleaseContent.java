package com.yantz.boot.release.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yantz.boot.common.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 发布内容实体对象
 *
 * @author yantz
 * @since 2025-03-02 13:47
 */
@Getter
@Setter
@TableName("pms_release_content")
public class PmsReleaseContent extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 内容ID
     */
    @TableId(value = "content_id", type = IdType.AUTO)
    private Long contentId;
    /**
     * 发布ID
     */
    private Long releaseId;
    /**
     * 内容
     */
    private String content;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 创建人ID
     */
    private Long createBy;
    /**
     * 更新人ID
     */
    private Long updateBy;
    /**
     * 是否删除（0: 未删除, 1: 已删除）
     */
    private Integer isDeleted;
}
