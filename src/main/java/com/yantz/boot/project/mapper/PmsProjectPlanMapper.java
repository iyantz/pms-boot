package com.yantz.boot.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yantz.boot.project.model.entity.PmsProjectPlan;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.project.model.query.PmsProjectPlanQuery;
import com.yantz.boot.project.model.vo.PmsProjectPlanVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目计划Mapper接口
 *
 * @author yantz
 * @since 2025-03-02 14:02
 */
@Mapper
public interface PmsProjectPlanMapper extends BaseMapper<PmsProjectPlan> {

    /**
     * 获取项目计划分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return
     */
    Page<PmsProjectPlanVO> getPmsProjectPlanPage(Page<PmsProjectPlanVO> page, PmsProjectPlanQuery queryParams);

}
