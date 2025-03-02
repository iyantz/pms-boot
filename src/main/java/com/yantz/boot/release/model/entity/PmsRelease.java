package com.yantz.boot.release.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yantz.boot.common.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 发布列表实体对象
 *
 * @author yantz
 * @since 2025-03-02 13:44
 */
@Getter
@Setter
@TableName("pms_release")
public class PmsRelease extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 发布ID
     */
    @TableId(value = "release_id", type = IdType.AUTO)
    private Long releaseId;
    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 计划版本
     */
    private String planVersion;
    /**
     * 发布模块
     */
    private String releaseModule;
    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime releaseTime;
    /**
     * 描述
     */
    private String description;
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
