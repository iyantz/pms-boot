package com.yantz.boot.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.project.model.entity.PmsRequirement;
import com.yantz.boot.project.model.query.PmsRequirementQuery;
import com.yantz.boot.project.model.vo.PmsRequirementVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 需求信息Mapper接口
 *
 * @author yantz
 * @since 2025-03-02 13:22
 */
@Mapper
public interface PmsRequirementMapper extends BaseMapper<PmsRequirement> {

    /**
     * 获取需求信息分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return
     */
    Page<PmsRequirementVO> getPmsRequirementPage(Page<PmsRequirementVO> page, PmsRequirementQuery queryParams);

}
