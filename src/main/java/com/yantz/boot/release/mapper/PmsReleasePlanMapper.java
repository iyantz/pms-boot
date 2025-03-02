package com.yantz.boot.release.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yantz.boot.release.model.entity.PmsReleasePlan;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.release.model.query.PmsReleasePlanQuery;
import com.yantz.boot.release.model.vo.PmsReleasePlanVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 发布计划Mapper接口
 *
 * @author yantz
 * @since 2025-03-02 13:40
 */
@Mapper
public interface PmsReleasePlanMapper extends BaseMapper<PmsReleasePlan> {

    /**
     * 获取发布计划分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return
     */
    Page<PmsReleasePlanVO> getPmsReleasePlanPage(Page<PmsReleasePlanVO> page, PmsReleasePlanQuery queryParams);

}
