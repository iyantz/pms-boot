package com.yantz.boot.workorder.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yantz.boot.common.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 工单列表实体对象
 *
 * @author yantz
 * @since 2025-03-02 13:37
 */
@Getter
@Setter
@TableName("pms_work_order")
public class PmsWorkOrder extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 工单ID
     */
    @TableId(value = "work_order_id", type = IdType.AUTO)
    private Long workOrderId;
    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 需求ID
     */
    private Long requirementId;
    /**
     * 工单标题
     */
    private String title;
    /**
     * 工单描述
     */
    private String description;
    /**
     * 指定处理人ID
     */
    private Long handlerId;
    /**
     * 处理时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime handlerTime;
    /**
     * 优先级（1低 2中 3高）
     */
    private String priority;
    /**
     * 工单状态（0待处理 1处理中 2已处理）
     */
    private String status;
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
