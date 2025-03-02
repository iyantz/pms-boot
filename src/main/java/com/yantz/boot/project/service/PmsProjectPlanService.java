package com.yantz.boot.project.service;

import com.yantz.boot.project.model.entity.PmsProjectPlan;
import com.yantz.boot.project.model.form.PmsProjectPlanForm;
import com.yantz.boot.project.model.query.PmsProjectPlanQuery;
import com.yantz.boot.project.model.vo.PmsProjectPlanVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 项目计划服务类
 *
 * @author yantz
 * @since 2025-03-02 14:02
 */
public interface PmsProjectPlanService extends IService<PmsProjectPlan> {

    /**
     *项目计划分页列表
     *
     * @return
     */
    IPage<PmsProjectPlanVO> getPmsProjectPlanPage(PmsProjectPlanQuery queryParams);

    /**
     * 获取项目计划表单数据
     *
     * @param id 项目计划ID
     * @return
     */
     PmsProjectPlanForm getPmsProjectPlanFormData(Long id);

    /**
     * 新增项目计划
     *
     * @param formData 项目计划表单对象
     * @return
     */
    boolean savePmsProjectPlan(PmsProjectPlanForm formData);

    /**
     * 修改项目计划
     *
     * @param id   项目计划ID
     * @param formData 项目计划表单对象
     * @return
     */
    boolean updatePmsProjectPlan(Long id, PmsProjectPlanForm formData);

    /**
     * 删除项目计划
     *
     * @param ids 项目计划ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deletePmsProjectPlans(String ids);

}
