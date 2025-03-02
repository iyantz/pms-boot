package com.yantz.boot.release.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yantz.boot.release.model.entity.PmsReleasePlan;
import com.yantz.boot.release.model.form.PmsReleasePlanForm;
import com.yantz.boot.release.model.query.PmsReleasePlanQuery;
import com.yantz.boot.release.model.vo.PmsReleasePlanVO;

/**
 * 发布计划服务类
 *
 * @author yantz
 * @since 2025-03-02 13:40
 */
public interface PmsReleasePlanService extends IService<PmsReleasePlan> {

    /**
     *发布计划分页列表
     *
     * @return
     */
    IPage<PmsReleasePlanVO> getPmsReleasePlanPage(PmsReleasePlanQuery queryParams);

    /**
     * 获取发布计划表单数据
     *
     * @param id 发布计划ID
     * @return
     */
     PmsReleasePlanForm getPmsReleasePlanFormData(Long id);

    /**
     * 新增发布计划
     *
     * @param formData 发布计划表单对象
     * @return
     */
    boolean savePmsReleasePlan(PmsReleasePlanForm formData);

    /**
     * 修改发布计划
     *
     * @param id   发布计划ID
     * @param formData 发布计划表单对象
     * @return
     */
    boolean updatePmsReleasePlan(Long id, PmsReleasePlanForm formData);

    /**
     * 删除发布计划
     *
     * @param ids 发布计划ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deletePmsReleasePlans(String ids);

}
