package com.yantz.boot.workorder.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yantz.boot.workorder.model.entity.PmsWorkOrder;
import com.yantz.boot.workorder.model.form.PmsWorkOrderForm;
import com.yantz.boot.workorder.model.query.PmsWorkOrderQuery;
import com.yantz.boot.workorder.model.vo.PmsWorkOrderVO;

/**
 * 工单列表服务类
 *
 * @author yantz
 * @since 2025-03-02 13:37
 */
public interface PmsWorkOrderService extends IService<PmsWorkOrder> {

    /**
     *工单列表分页列表
     *
     * @return
     */
    IPage<PmsWorkOrderVO> getPmsWorkOrderPage(PmsWorkOrderQuery queryParams);

    /**
     * 获取工单列表表单数据
     *
     * @param id 工单列表ID
     * @return
     */
     PmsWorkOrderForm getPmsWorkOrderFormData(Long id);

    /**
     * 新增工单列表
     *
     * @param formData 工单列表表单对象
     * @return
     */
    boolean savePmsWorkOrder(PmsWorkOrderForm formData);

    /**
     * 修改工单列表
     *
     * @param id   工单列表ID
     * @param formData 工单列表表单对象
     * @return
     */
    boolean updatePmsWorkOrder(Long id, PmsWorkOrderForm formData);

    /**
     * 删除工单列表
     *
     * @param ids 工单列表ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deletePmsWorkOrders(String ids);

}
