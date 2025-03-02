package com.yantz.boot.task.service;

import com.yantz.boot.task.model.entity.PmsTask;
import com.yantz.boot.task.model.form.PmsTaskForm;
import com.yantz.boot.task.model.query.PmsTaskQuery;
import com.yantz.boot.task.model.vo.PmsTaskVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 任务列表服务类
 *
 * @author yantz
 * @since 2025-03-02 13:34
 */
public interface PmsTaskService extends IService<PmsTask> {

    /**
     *任务列表分页列表
     *
     * @return
     */
    IPage<PmsTaskVO> getPmsTaskPage(PmsTaskQuery queryParams);

    /**
     * 获取任务列表表单数据
     *
     * @param id 任务列表ID
     * @return
     */
     PmsTaskForm getPmsTaskFormData(Long id);

    /**
     * 新增任务列表
     *
     * @param formData 任务列表表单对象
     * @return
     */
    boolean savePmsTask(PmsTaskForm formData);

    /**
     * 修改任务列表
     *
     * @param id   任务列表ID
     * @param formData 任务列表表单对象
     * @return
     */
    boolean updatePmsTask(Long id, PmsTaskForm formData);

    /**
     * 删除任务列表
     *
     * @param ids 任务列表ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deletePmsTasks(String ids);

}
