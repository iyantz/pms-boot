package com.yantz.boot.project.service;

import com.yantz.boot.project.model.entity.PmsProject;
import com.yantz.boot.project.model.form.PmsProjectForm;
import com.yantz.boot.project.model.query.PmsProjectQuery;
import com.yantz.boot.project.model.vo.PmsProjectVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 项目信息服务类
 *
 * @author yantz
 * @since 2025-03-02 14:04
 */
public interface PmsProjectService extends IService<PmsProject> {

    /**
     *项目信息分页列表
     *
     * @return
     */
    IPage<PmsProjectVO> getPmsProjectPage(PmsProjectQuery queryParams);

    /**
     * 获取项目信息表单数据
     *
     * @param id 项目信息ID
     * @return
     */
     PmsProjectForm getPmsProjectFormData(Long id);

    /**
     * 新增项目信息
     *
     * @param formData 项目信息表单对象
     * @return
     */
    boolean savePmsProject(PmsProjectForm formData);

    /**
     * 修改项目信息
     *
     * @param id   项目信息ID
     * @param formData 项目信息表单对象
     * @return
     */
    boolean updatePmsProject(Long id, PmsProjectForm formData);

    /**
     * 删除项目信息
     *
     * @param ids 项目信息ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deletePmsProjects(String ids);

}
