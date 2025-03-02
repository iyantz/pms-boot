package com.yantz.boot.project.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yantz.boot.common.base.BaseEntity;

/**
 * 需求信息实体对象
 *
 * @author yantz
 * @since 2025-03-02 13:22
 */
@Getter
@Setter
@TableName("pms_requirement")
public class PmsRequirement extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 需求ID
     */
    private Long requirementId;
    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 需求名称
     */
    private String requirementName;
    /**
     * 需求提出人
     */
    private String proposer;
    /**
     * 需求提出时间
     */
    private LocalDateTime proposeTime;
    /**
     * 预计完成时间
     */
    private LocalDateTime expectFinishTime;
    /**
     * 完成状态
     */
    private Integer status;
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
