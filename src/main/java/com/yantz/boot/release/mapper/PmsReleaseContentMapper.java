package com.yantz.boot.release.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.release.model.entity.PmsReleaseContent;
import com.yantz.boot.release.model.query.PmsReleaseContentQuery;
import com.yantz.boot.release.model.vo.PmsReleaseContentVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 发布内容Mapper接口
 *
 * @author yantz
 * @since 2025-03-02 13:47
 */
@Mapper
public interface PmsReleaseContentMapper extends BaseMapper<PmsReleaseContent> {

    /**
     * 获取发布内容分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return
     */
    Page<PmsReleaseContentVO> getPmsReleaseContentPage(Page<PmsReleaseContentVO> page, PmsReleaseContentQuery queryParams);

}
