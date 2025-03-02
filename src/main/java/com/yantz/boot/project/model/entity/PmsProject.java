package com.yantz.boot.project.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yantz.boot.common.base.BaseEntity;

/**
 * 项目信息实体对象
 *
 * @author yantz
 * @since 2025-03-02 14:04
 */
@Getter
@Setter
@TableName("pms_project")
public class PmsProject extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 项目简称
     */
    private String projectShortName;
    /**
     * 合同甲方
     */
    private String partyA;
    /**
     * 合同乙方
     */
    private String partyB;
    /**
     * 项目周期
     */
    private String projectPeriod;
    /**
     * 项目金额
     */
    private BigDecimal projectAmount;
    /**
     * 简介
     */
    private String description;
    /**
     * 备注
     */
    private String remark;
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
