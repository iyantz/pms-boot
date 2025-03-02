package com.yantz.boot.release.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yantz.boot.release.converter.PmsReleasePlanConverter;
import com.yantz.boot.release.mapper.PmsReleasePlanMapper;
import com.yantz.boot.release.model.entity.PmsReleasePlan;
import com.yantz.boot.release.model.form.PmsReleasePlanForm;
import com.yantz.boot.release.model.query.PmsReleasePlanQuery;
import com.yantz.boot.release.model.vo.PmsReleasePlanVO;
import com.yantz.boot.release.service.PmsReleasePlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 发布计划服务实现类
 *
 * @author yantz
 * @since 2025-03-02 13:40
 */
@Service
@RequiredArgsConstructor
public class PmsReleasePlanServiceImpl extends ServiceImpl<PmsReleasePlanMapper, PmsReleasePlan> implements PmsReleasePlanService {

    private final PmsReleasePlanConverter pmsReleasePlanConverter;

    /**
    * 获取发布计划分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<PmsReleasePlanVO>} 发布计划分页列表
    */
    @Override
    public IPage<PmsReleasePlanVO> getPmsReleasePlanPage(PmsReleasePlanQuery queryParams) {
        Page<PmsReleasePlanVO> pageVO = this.baseMapper.getPmsReleasePlanPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取发布计划表单数据
     *
     * @param id 发布计划ID
     * @return
     */
    @Override
    public PmsReleasePlanForm getPmsReleasePlanFormData(Long id) {
        PmsReleasePlan entity = this.getById(id);
        return pmsReleasePlanConverter.toForm(entity);
    }
    
    /**
     * 新增发布计划
     *
     * @param formData 发布计划表单对象
     * @return
     */
    @Override
    public boolean savePmsReleasePlan(PmsReleasePlanForm formData) {
        PmsReleasePlan entity = pmsReleasePlanConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新发布计划
     *
     * @param id   发布计划ID
     * @param formData 发布计划表单对象
     * @return
     */
    @Override
    public boolean updatePmsReleasePlan(Long id,PmsReleasePlanForm formData) {
        PmsReleasePlan entity = pmsReleasePlanConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除发布计划
     *
     * @param ids 发布计划ID，多个以英文逗号(,)分割
     * @return
     */
    @Override
    public boolean deletePmsReleasePlans(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的发布计划数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
