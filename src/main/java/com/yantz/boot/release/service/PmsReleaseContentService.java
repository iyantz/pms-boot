package com.yantz.boot.release.service;

import com.yantz.boot.release.model.entity.PmsReleaseContent;
import com.yantz.boot.release.model.form.PmsReleaseContentForm;
import com.yantz.boot.release.model.query.PmsReleaseContentQuery;
import com.yantz.boot.release.model.vo.PmsReleaseContentVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 发布内容服务类
 *
 * @author yantz
 * @since 2025-03-02 13:47
 */
public interface PmsReleaseContentService extends IService<PmsReleaseContent> {

    /**
     *发布内容分页列表
     *
     * @return
     */
    IPage<PmsReleaseContentVO> getPmsReleaseContentPage(PmsReleaseContentQuery queryParams);

    /**
     * 获取发布内容表单数据
     *
     * @param id 发布内容ID
     * @return
     */
     PmsReleaseContentForm getPmsReleaseContentFormData(Long id);

    /**
     * 新增发布内容
     *
     * @param formData 发布内容表单对象
     * @return
     */
    boolean savePmsReleaseContent(PmsReleaseContentForm formData);

    /**
     * 修改发布内容
     *
     * @param id   发布内容ID
     * @param formData 发布内容表单对象
     * @return
     */
    boolean updatePmsReleaseContent(Long id, PmsReleaseContentForm formData);

    /**
     * 删除发布内容
     *
     * @param ids 发布内容ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deletePmsReleaseContents(String ids);

}
