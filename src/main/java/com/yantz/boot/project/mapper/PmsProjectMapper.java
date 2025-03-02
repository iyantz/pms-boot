package com.yantz.boot.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.project.model.entity.PmsProject;
import com.yantz.boot.project.model.query.PmsProjectQuery;
import com.yantz.boot.project.model.vo.PmsProjectVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目信息Mapper接口
 *
 * @author yantz
 * @since 2025-03-02 14:04
 */
@Mapper
public interface PmsProjectMapper extends BaseMapper<PmsProject> {

    /**
     * 获取项目信息分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return
     */
    Page<PmsProjectVO> getPmsProjectPage(Page<PmsProjectVO> page, PmsProjectQuery queryParams);

}
