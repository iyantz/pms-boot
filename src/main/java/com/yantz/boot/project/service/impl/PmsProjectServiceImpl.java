package com.yantz.boot.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yantz.boot.project.mapper.PmsProjectMapper;
import com.yantz.boot.project.service.PmsProjectService;
import com.yantz.boot.project.model.entity.PmsProject;
import com.yantz.boot.project.model.form.PmsProjectForm;
import com.yantz.boot.project.model.query.PmsProjectQuery;
import com.yantz.boot.project.model.vo.PmsProjectVO;
import com.yantz.boot.project.converter.PmsProjectConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 项目信息服务实现类
 *
 * @author yantz
 * @since 2025-03-02 14:04
 */
@Service
@RequiredArgsConstructor
public class PmsProjectServiceImpl extends ServiceImpl<PmsProjectMapper, PmsProject> implements PmsProjectService {

    private final PmsProjectConverter pmsProjectConverter;

    /**
    * 获取项目信息分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<PmsProjectVO>} 项目信息分页列表
    */
    @Override
    public IPage<PmsProjectVO> getPmsProjectPage(PmsProjectQuery queryParams) {
        Page<PmsProjectVO> pageVO = this.baseMapper.getPmsProjectPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取项目信息表单数据
     *
     * @param id 项目信息ID
     * @return
     */
    @Override
    public PmsProjectForm getPmsProjectFormData(Long id) {
        PmsProject entity = this.getById(id);
        return pmsProjectConverter.toForm(entity);
    }
    
    /**
     * 新增项目信息
     *
     * @param formData 项目信息表单对象
     * @return
     */
    @Override
    public boolean savePmsProject(PmsProjectForm formData) {
        PmsProject entity = pmsProjectConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新项目信息
     *
     * @param id   项目信息ID
     * @param formData 项目信息表单对象
     * @return
     */
    @Override
    public boolean updatePmsProject(Long id,PmsProjectForm formData) {
        PmsProject entity = pmsProjectConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除项目信息
     *
     * @param ids 项目信息ID，多个以英文逗号(,)分割
     * @return
     */
    @Override
    public boolean deletePmsProjects(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的项目信息数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
