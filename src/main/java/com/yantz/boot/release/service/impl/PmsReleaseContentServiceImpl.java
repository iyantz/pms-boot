package com.yantz.boot.release.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yantz.boot.release.converter.PmsReleaseContentConverter;
import com.yantz.boot.release.mapper.PmsReleaseContentMapper;
import com.yantz.boot.release.model.entity.PmsReleaseContent;
import com.yantz.boot.release.model.form.PmsReleaseContentForm;
import com.yantz.boot.release.model.query.PmsReleaseContentQuery;
import com.yantz.boot.release.model.vo.PmsReleaseContentVO;
import com.yantz.boot.release.service.PmsReleaseContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 发布内容服务实现类
 *
 * @author yantz
 * @since 2025-03-02 13:47
 */
@Service
@RequiredArgsConstructor
public class PmsReleaseContentServiceImpl extends ServiceImpl<PmsReleaseContentMapper, PmsReleaseContent> implements PmsReleaseContentService {

    private final PmsReleaseContentConverter pmsReleaseContentConverter;

    /**
    * 获取发布内容分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<PmsReleaseContentVO>} 发布内容分页列表
    */
    @Override
    public IPage<PmsReleaseContentVO> getPmsReleaseContentPage(PmsReleaseContentQuery queryParams) {
        Page<PmsReleaseContentVO> pageVO = this.baseMapper.getPmsReleaseContentPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取发布内容表单数据
     *
     * @param id 发布内容ID
     * @return
     */
    @Override
    public PmsReleaseContentForm getPmsReleaseContentFormData(Long id) {
        PmsReleaseContent entity = this.getById(id);
        return pmsReleaseContentConverter.toForm(entity);
    }
    
    /**
     * 新增发布内容
     *
     * @param formData 发布内容表单对象
     * @return
     */
    @Override
    public boolean savePmsReleaseContent(PmsReleaseContentForm formData) {
        PmsReleaseContent entity = pmsReleaseContentConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新发布内容
     *
     * @param id   发布内容ID
     * @param formData 发布内容表单对象
     * @return
     */
    @Override
    public boolean updatePmsReleaseContent(Long id,PmsReleaseContentForm formData) {
        PmsReleaseContent entity = pmsReleaseContentConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除发布内容
     *
     * @param ids 发布内容ID，多个以英文逗号(,)分割
     * @return
     */
    @Override
    public boolean deletePmsReleaseContents(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的发布内容数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
