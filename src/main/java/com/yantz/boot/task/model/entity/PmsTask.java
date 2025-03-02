package com.yantz.boot.task.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yantz.boot.common.base.BaseEntity;

/**
 * 任务列表实体对象
 *
 * @author yantz
 * @since 2025-03-02 13:34
 */
@Getter
@Setter
@TableName("pms_task")
public class PmsTask extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 任务ID
     */
    private Long taskId;
    /**
     * 需求ID
     */
    private Long requirementId;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 优先级
     */
    private String priority;
    /**
     * 预计开始时间
     */
    private LocalDateTime expectStartTime;
    /**
     * 预计完成时间
     */
    private LocalDateTime expectFinishTime;
    /**
     * 完成状态
     */
    private Integer status;
    /**
     * 实际开始时间
     */
    private LocalDateTime actualStartTime;
    /**
     * 实际完成时间
     */
    private LocalDateTime actualFinishTime;
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
