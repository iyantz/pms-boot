package com.yantz.boot.task.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yantz.boot.common.base.BaseEntity;

/**
 * 缺陷管理实体对象
 *
 * @author yantz
 * @since 2025-03-02 13:31
 */
@Getter
@Setter
@TableName("pms_defect")
public class PmsDefect extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 缺陷ID
     */
    private Long defectId;
    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 缺陷名称
     */
    private String defectName;
    /**
     * 缺陷提出人
     */
    private String proposer;
    /**
     * 缺陷修复人
     */
    private String fixer;
    /**
     * 缺陷提出时间
     */
    private LocalDateTime proposeTime;
    /**
     * 缺陷修复时间
     */
    private LocalDateTime fixTime;
    /**
     * 缺陷修复状态
     */
    private String fixStatus;
    /**
     * 缺陷优先级
     */
    private String priority;
    /**
     * 缺陷类型
     */
    private String defectType;
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
