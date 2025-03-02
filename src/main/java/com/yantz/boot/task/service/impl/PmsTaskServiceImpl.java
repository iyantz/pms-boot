package com.yantz.boot.task.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yantz.boot.task.mapper.PmsTaskMapper;
import com.yantz.boot.task.service.PmsTaskService;
import com.yantz.boot.task.model.entity.PmsTask;
import com.yantz.boot.task.model.form.PmsTaskForm;
import com.yantz.boot.task.model.query.PmsTaskQuery;
import com.yantz.boot.task.model.vo.PmsTaskVO;
import com.yantz.boot.task.converter.PmsTaskConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 任务列表服务实现类
 *
 * @author yantz
 * @since 2025-03-02 13:34
 */
@Service
@RequiredArgsConstructor
public class PmsTaskServiceImpl extends ServiceImpl<PmsTaskMapper, PmsTask> implements PmsTaskService {

    private final PmsTaskConverter pmsTaskConverter;

    /**
    * 获取任务列表分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<PmsTaskVO>} 任务列表分页列表
    */
    @Override
    public IPage<PmsTaskVO> getPmsTaskPage(PmsTaskQuery queryParams) {
        Page<PmsTaskVO> pageVO = this.baseMapper.getPmsTaskPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取任务列表表单数据
     *
     * @param id 任务列表ID
     * @return
     */
    @Override
    public PmsTaskForm getPmsTaskFormData(Long id) {
        PmsTask entity = this.getById(id);
        return pmsTaskConverter.toForm(entity);
    }
    
    /**
     * 新增任务列表
     *
     * @param formData 任务列表表单对象
     * @return
     */
    @Override
    public boolean savePmsTask(PmsTaskForm formData) {
        PmsTask entity = pmsTaskConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新任务列表
     *
     * @param id   任务列表ID
     * @param formData 任务列表表单对象
     * @return
     */
    @Override
    public boolean updatePmsTask(Long id,PmsTaskForm formData) {
        PmsTask entity = pmsTaskConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除任务列表
     *
     * @param ids 任务列表ID，多个以英文逗号(,)分割
     * @return
     */
    @Override
    public boolean deletePmsTasks(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的任务列表数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
