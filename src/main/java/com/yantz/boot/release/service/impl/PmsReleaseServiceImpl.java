package com.yantz.boot.release.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yantz.boot.release.converter.PmsReleaseConverter;
import com.yantz.boot.release.mapper.PmsReleaseMapper;
import com.yantz.boot.release.model.entity.PmsRelease;
import com.yantz.boot.release.model.form.PmsReleaseForm;
import com.yantz.boot.release.model.query.PmsReleaseQuery;
import com.yantz.boot.release.model.vo.PmsReleaseVO;
import com.yantz.boot.release.service.PmsReleaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 发布列表服务实现类
 *
 * @author yantz
 * @since 2025-03-02 13:44
 */
@Service
@RequiredArgsConstructor
public class PmsReleaseServiceImpl extends ServiceImpl<PmsReleaseMapper, PmsRelease> implements PmsReleaseService {

    private final PmsReleaseConverter pmsReleaseConverter;

    /**
    * 获取发布列表分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<PmsReleaseVO>} 发布列表分页列表
    */
    @Override
    public IPage<PmsReleaseVO> getPmsReleasePage(PmsReleaseQuery queryParams) {
        Page<PmsReleaseVO> pageVO = this.baseMapper.getPmsReleasePage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取发布列表表单数据
     *
     * @param id 发布列表ID
     * @return
     */
    @Override
    public PmsReleaseForm getPmsReleaseFormData(Long id) {
        PmsRelease entity = this.getById(id);
        return pmsReleaseConverter.toForm(entity);
    }
    
    /**
     * 新增发布列表
     *
     * @param formData 发布列表表单对象
     * @return
     */
    @Override
    public boolean savePmsRelease(PmsReleaseForm formData) {
        PmsRelease entity = pmsReleaseConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新发布列表
     *
     * @param id   发布列表ID
     * @param formData 发布列表表单对象
     * @return
     */
    @Override
    public boolean updatePmsRelease(Long id,PmsReleaseForm formData) {
        PmsRelease entity = pmsReleaseConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除发布列表
     *
     * @param ids 发布列表ID，多个以英文逗号(,)分割
     * @return
     */
    @Override
    public boolean deletePmsReleases(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的发布列表数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
