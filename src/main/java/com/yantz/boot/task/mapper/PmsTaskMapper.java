package com.yantz.boot.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.task.model.entity.PmsTask;
import com.yantz.boot.task.model.query.PmsTaskQuery;
import com.yantz.boot.task.model.vo.PmsTaskVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 任务列表Mapper接口
 *
 * @author yantz
 * @since 2025-03-02 13:34
 */
@Mapper
public interface PmsTaskMapper extends BaseMapper<PmsTask> {

    /**
     * 获取任务列表分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return
     */
    Page<PmsTaskVO> getPmsTaskPage(Page<PmsTaskVO> page, PmsTaskQuery queryParams);

}
