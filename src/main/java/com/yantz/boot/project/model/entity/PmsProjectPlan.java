package com.yantz.boot.project.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yantz.boot.common.base.BaseEntity;

/**
 * 项目计划实体对象
 *
 * @author yantz
 * @since 2025-03-02 14:02
 */
@Getter
@Setter
@TableName("pms_project_plan")
public class PmsProjectPlan extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 计划ID
     */
    private Long planId;
    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 计划名称
     */
    private String planName;
    /**
     * 计划完成时间
     */
    private LocalDateTime planTime;
    /**
     * 实际完成时间
     */
    private LocalDateTime planActualTime;
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
