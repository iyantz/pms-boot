package com.yantz.boot.project.service;

import com.yantz.boot.project.model.entity.PmsRequirement;
import com.yantz.boot.project.model.form.PmsRequirementForm;
import com.yantz.boot.project.model.query.PmsRequirementQuery;
import com.yantz.boot.project.model.vo.PmsRequirementVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 需求信息服务类
 *
 * @author yantz
 * @since 2025-03-02 13:22
 */
public interface PmsRequirementService extends IService<PmsRequirement> {

    /**
     *需求信息分页列表
     *
     * @return
     */
    IPage<PmsRequirementVO> getPmsRequirementPage(PmsRequirementQuery queryParams);

    /**
     * 获取需求信息表单数据
     *
     * @param id 需求信息ID
     * @return
     */
     PmsRequirementForm getPmsRequirementFormData(Long id);

    /**
     * 新增需求信息
     *
     * @param formData 需求信息表单对象
     * @return
     */
    boolean savePmsRequirement(PmsRequirementForm formData);

    /**
     * 修改需求信息
     *
     * @param id   需求信息ID
     * @param formData 需求信息表单对象
     * @return
     */
    boolean updatePmsRequirement(Long id, PmsRequirementForm formData);

    /**
     * 删除需求信息
     *
     * @param ids 需求信息ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deletePmsRequirements(String ids);

}
