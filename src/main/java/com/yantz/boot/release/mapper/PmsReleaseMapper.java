package com.yantz.boot.release.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.release.model.entity.PmsRelease;
import com.yantz.boot.release.model.query.PmsReleaseQuery;
import com.yantz.boot.release.model.vo.PmsReleaseVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 发布列表Mapper接口
 *
 * @author yantz
 * @since 2025-03-02 13:44
 */
@Mapper
public interface PmsReleaseMapper extends BaseMapper<PmsRelease> {

    /**
     * 获取发布列表分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return
     */
    Page<PmsReleaseVO> getPmsReleasePage(Page<PmsReleaseVO> page, PmsReleaseQuery queryParams);

}
