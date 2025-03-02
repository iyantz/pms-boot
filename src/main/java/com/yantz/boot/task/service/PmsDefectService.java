package com.yantz.boot.task.service;

import com.yantz.boot.task.model.entity.PmsDefect;
import com.yantz.boot.task.model.form.PmsDefectForm;
import com.yantz.boot.task.model.query.PmsDefectQuery;
import com.yantz.boot.task.model.vo.PmsDefectVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 缺陷管理服务类
 *
 * @author yantz
 * @since 2025-03-02 13:31
 */
public interface PmsDefectService extends IService<PmsDefect> {

    /**
     *缺陷管理分页列表
     *
     * @return
     */
    IPage<PmsDefectVO> getPmsDefectPage(PmsDefectQuery queryParams);

    /**
     * 获取缺陷管理表单数据
     *
     * @param id 缺陷管理ID
     * @return
     */
     PmsDefectForm getPmsDefectFormData(Long id);

    /**
     * 新增缺陷管理
     *
     * @param formData 缺陷管理表单对象
     * @return
     */
    boolean savePmsDefect(PmsDefectForm formData);

    /**
     * 修改缺陷管理
     *
     * @param id   缺陷管理ID
     * @param formData 缺陷管理表单对象
     * @return
     */
    boolean updatePmsDefect(Long id, PmsDefectForm formData);

    /**
     * 删除缺陷管理
     *
     * @param ids 缺陷管理ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deletePmsDefects(String ids);

}
