package com.yantz.boot.task.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yantz.boot.task.converter.PmsDefectConverter;
import com.yantz.boot.task.mapper.PmsDefectMapper;
import com.yantz.boot.task.model.entity.PmsDefect;
import com.yantz.boot.task.model.form.PmsDefectForm;
import com.yantz.boot.task.model.query.PmsDefectQuery;
import com.yantz.boot.task.model.vo.PmsDefectVO;
import com.yantz.boot.task.service.PmsDefectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 缺陷管理服务实现类
 *
 * @author yantz
 * @since 2025-03-02 13:31
 */
@Service
@RequiredArgsConstructor
public class PmsDefectServiceImpl extends ServiceImpl<PmsDefectMapper, PmsDefect> implements PmsDefectService {

    private final PmsDefectConverter pmsDefectConverter;

    /**
    * 获取缺陷管理分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<PmsDefectVO>} 缺陷管理分页列表
    */
    @Override
    public IPage<PmsDefectVO> getPmsDefectPage(PmsDefectQuery queryParams) {
        Page<PmsDefectVO> pageVO = this.baseMapper.getPmsDefectPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取缺陷管理表单数据
     *
     * @param id 缺陷管理ID
     * @return
     */
    @Override
    public PmsDefectForm getPmsDefectFormData(Long id) {
        PmsDefect entity = this.getById(id);
        return pmsDefectConverter.toForm(entity);
    }
    
    /**
     * 新增缺陷管理
     *
     * @param formData 缺陷管理表单对象
     * @return
     */
    @Override
    public boolean savePmsDefect(PmsDefectForm formData) {
        PmsDefect entity = pmsDefectConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新缺陷管理
     *
     * @param id   缺陷管理ID
     * @param formData 缺陷管理表单对象
     * @return
     */
    @Override
    public boolean updatePmsDefect(Long id,PmsDefectForm formData) {
        PmsDefect entity = pmsDefectConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除缺陷管理
     *
     * @param ids 缺陷管理ID，多个以英文逗号(,)分割
     * @return
     */
    @Override
    public boolean deletePmsDefects(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的缺陷管理数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
