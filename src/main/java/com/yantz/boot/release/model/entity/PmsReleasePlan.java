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
 * 发布计划实体对象
 *
 * @author yantz
 * @since 2025-03-02 13:40
 */
@Getter
@Setter
@TableName("pms_release_plan")
public class PmsReleasePlan extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 计划ID
     */
    @TableId(value = "plan_id", type = IdType.AUTO)
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
     * 计划版本
     */
    private String planVersion;
    /**
     * 计划时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planTime;
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
