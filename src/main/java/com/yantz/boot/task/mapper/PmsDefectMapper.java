package com.yantz.boot.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yantz.boot.task.model.entity.PmsDefect;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.task.model.query.PmsDefectQuery;
import com.yantz.boot.task.model.vo.PmsDefectVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 缺陷管理Mapper接口
 *
 * @author yantz
 * @since 2025-03-02 13:31
 */
@Mapper
public interface PmsDefectMapper extends BaseMapper<PmsDefect> {

    /**
     * 获取缺陷管理分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return
     */
    Page<PmsDefectVO> getPmsDefectPage(Page<PmsDefectVO> page, PmsDefectQuery queryParams);

}
