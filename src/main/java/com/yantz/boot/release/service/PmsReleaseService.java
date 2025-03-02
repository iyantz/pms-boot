package com.yantz.boot.release.service;

import com.yantz.boot.release.model.entity.PmsRelease;
import com.yantz.boot.release.model.form.PmsReleaseForm;
import com.yantz.boot.release.model.query.PmsReleaseQuery;
import com.yantz.boot.release.model.vo.PmsReleaseVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 发布列表服务类
 *
 * @author yantz
 * @since 2025-03-02 13:44
 */
public interface PmsReleaseService extends IService<PmsRelease> {

    /**
     *发布列表分页列表
     *
     * @return
     */
    IPage<PmsReleaseVO> getPmsReleasePage(PmsReleaseQuery queryParams);

    /**
     * 获取发布列表表单数据
     *
     * @param id 发布列表ID
     * @return
     */
     PmsReleaseForm getPmsReleaseFormData(Long id);

    /**
     * 新增发布列表
     *
     * @param formData 发布列表表单对象
     * @return
     */
    boolean savePmsRelease(PmsReleaseForm formData);

    /**
     * 修改发布列表
     *
     * @param id   发布列表ID
     * @param formData 发布列表表单对象
     * @return
     */
    boolean updatePmsRelease(Long id, PmsReleaseForm formData);

    /**
     * 删除发布列表
     *
     * @param ids 发布列表ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deletePmsReleases(String ids);

}
