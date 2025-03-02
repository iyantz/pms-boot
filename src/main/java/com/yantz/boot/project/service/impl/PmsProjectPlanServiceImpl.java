package com.yantz.boot.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yantz.boot.project.mapper.PmsProjectPlanMapper;
import com.yantz.boot.project.service.PmsProjectPlanService;
import com.yantz.boot.project.model.entity.PmsProjectPlan;
import com.yantz.boot.project.model.form.PmsProjectPlanForm;
import com.yantz.boot.project.model.query.PmsProjectPlanQuery;
import com.yantz.boot.project.model.vo.PmsProjectPlanVO;
import com.yantz.boot.project.converter.PmsProjectPlanConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 项目计划服务实现类
 *
 * @author yantz
 * @since 2025-03-02 14:02
 */
@Service
@RequiredArgsConstructor
public class PmsProjectPlanServiceImpl extends ServiceImpl<PmsProjectPlanMapper, PmsProjectPlan> implements PmsProjectPlanService {

    private final PmsProjectPlanConverter pmsProjectPlanConverter;

    /**
    * 获取项目计划分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<PmsProjectPlanVO>} 项目计划分页列表
    */
    @Override
    public IPage<PmsProjectPlanVO> getPmsProjectPlanPage(PmsProjectPlanQuery queryParams) {
        Page<PmsProjectPlanVO> pageVO = this.baseMapper.getPmsProjectPlanPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取项目计划表单数据
     *
     * @param id 项目计划ID
     * @return
     */
    @Override
    public PmsProjectPlanForm getPmsProjectPlanFormData(Long id) {
        PmsProjectPlan entity = this.getById(id);
        return pmsProjectPlanConverter.toForm(entity);
    }
    
    /**
     * 新增项目计划
     *
     * @param formData 项目计划表单对象
     * @return
     */
    @Override
    public boolean savePmsProjectPlan(PmsProjectPlanForm formData) {
        PmsProjectPlan entity = pmsProjectPlanConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新项目计划
     *
     * @param id   项目计划ID
     * @param formData 项目计划表单对象
     * @return
     */
    @Override
    public boolean updatePmsProjectPlan(Long id,PmsProjectPlanForm formData) {
        PmsProjectPlan entity = pmsProjectPlanConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除项目计划
     *
     * @param ids 项目计划ID，多个以英文逗号(,)分割
     * @return
     */
    @Override
    public boolean deletePmsProjectPlans(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的项目计划数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
