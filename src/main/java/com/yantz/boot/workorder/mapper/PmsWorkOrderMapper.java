package com.yantz.boot.workorder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yantz.boot.workorder.model.entity.PmsWorkOrder;
import com.yantz.boot.workorder.model.query.PmsWorkOrderQuery;
import com.yantz.boot.workorder.model.vo.PmsWorkOrderVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 工单列表Mapper接口
 *
 * @author yantz
 * @since 2025-03-02 13:37
 */
@Mapper
public interface PmsWorkOrderMapper extends BaseMapper<PmsWorkOrder> {

    /**
     * 获取工单列表分页数据
     *
     * @param page 分页对象
     * @param queryParams 查询参数
     * @return
     */
    Page<PmsWorkOrderVO> getPmsWorkOrderPage(Page<PmsWorkOrderVO> page, PmsWorkOrderQuery queryParams);

}
