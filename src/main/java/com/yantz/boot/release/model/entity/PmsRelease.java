package com.yantz.boot.release.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yantz.boot.common.base.BaseEntity;

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
