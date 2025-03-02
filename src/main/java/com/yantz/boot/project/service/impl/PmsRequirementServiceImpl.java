package com.yantz.boot.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yantz.boot.project.mapper.PmsRequirementMapper;
import com.yantz.boot.project.service.PmsRequirementService;
import com.yantz.boot.project.model.entity.PmsRequirement;
import com.yantz.boot.project.model.form.PmsRequirementForm;
import com.yantz.boot.project.model.query.PmsRequirementQuery;
import com.yantz.boot.project.model.vo.PmsRequirementVO;
import com.yantz.boot.project.converter.PmsRequirementConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 需求信息服务实现类
 *
 * @author yantz
 * @since 2025-03-02 13:22
 */
@Service
@RequiredArgsConstructor
public class PmsRequirementServiceImpl extends ServiceImpl<PmsRequirementMapper, PmsRequirement> implements PmsRequirementService {

    private final PmsRequirementConverter pmsRequirementConverter;

    /**
    * 获取需求信息分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<PmsRequirementVO>} 需求信息分页列表
    */
    @Override
    public IPage<PmsRequirementVO> getPmsRequirementPage(PmsRequirementQuery queryParams) {
        Page<PmsRequirementVO> pageVO = this.baseMapper.getPmsRequirementPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取需求信息表单数据
     *
     * @param id 需求信息ID
     * @return
     */
    @Override
    public PmsRequirementForm getPmsRequirementFormData(Long id) {
        PmsRequirement entity = this.getById(id);
        return pmsRequirementConverter.toForm(entity);
    }
    
    /**
     * 新增需求信息
     *
     * @param formData 需求信息表单对象
     * @return
     */
    @Override
    public boolean savePmsRequirement(PmsRequirementForm formData) {
        PmsRequirement entity = pmsRequirementConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新需求信息
     *
     * @param id   需求信息ID
     * @param formData 需求信息表单对象
     * @return
     */
    @Override
    public boolean updatePmsRequirement(Long id,PmsRequirementForm formData) {
        PmsRequirement entity = pmsRequirementConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除需求信息
     *
     * @param ids 需求信息ID，多个以英文逗号(,)分割
     * @return
     */
    @Override
    public boolean deletePmsRequirements(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的需求信息数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
