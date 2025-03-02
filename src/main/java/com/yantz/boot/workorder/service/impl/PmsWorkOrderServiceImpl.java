package com.yantz.boot.workorder.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yantz.boot.workorder.mapper.PmsWorkOrderMapper;
import com.yantz.boot.workorder.service.PmsWorkOrderService;
import com.yantz.boot.workorder.model.entity.PmsWorkOrder;
import com.yantz.boot.workorder.model.form.PmsWorkOrderForm;
import com.yantz.boot.workorder.model.query.PmsWorkOrderQuery;
import com.yantz.boot.workorder.model.vo.PmsWorkOrderVO;
import com.yantz.boot.workorder.converter.PmsWorkOrderConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

/**
 * 工单列表服务实现类
 *
 * @author yantz
 * @since 2025-03-02 13:37
 */
@Service
@RequiredArgsConstructor
public class PmsWorkOrderServiceImpl extends ServiceImpl<PmsWorkOrderMapper, PmsWorkOrder> implements PmsWorkOrderService {

    private final PmsWorkOrderConverter pmsWorkOrderConverter;

    /**
    * 获取工单列表分页列表
    *
    * @param queryParams 查询参数
    * @return {@link IPage<PmsWorkOrderVO>} 工单列表分页列表
    */
    @Override
    public IPage<PmsWorkOrderVO> getPmsWorkOrderPage(PmsWorkOrderQuery queryParams) {
        Page<PmsWorkOrderVO> pageVO = this.baseMapper.getPmsWorkOrderPage(
                new Page<>(queryParams.getPageNum(), queryParams.getPageSize()),
                queryParams
        );
        return pageVO;
    }
    
    /**
     * 获取工单列表表单数据
     *
     * @param id 工单列表ID
     * @return
     */
    @Override
    public PmsWorkOrderForm getPmsWorkOrderFormData(Long id) {
        PmsWorkOrder entity = this.getById(id);
        return pmsWorkOrderConverter.toForm(entity);
    }
    
    /**
     * 新增工单列表
     *
     * @param formData 工单列表表单对象
     * @return
     */
    @Override
    public boolean savePmsWorkOrder(PmsWorkOrderForm formData) {
        PmsWorkOrder entity = pmsWorkOrderConverter.toEntity(formData);
        return this.save(entity);
    }
    
    /**
     * 更新工单列表
     *
     * @param id   工单列表ID
     * @param formData 工单列表表单对象
     * @return
     */
    @Override
    public boolean updatePmsWorkOrder(Long id,PmsWorkOrderForm formData) {
        PmsWorkOrder entity = pmsWorkOrderConverter.toEntity(formData);
        return this.updateById(entity);
    }
    
    /**
     * 删除工单列表
     *
     * @param ids 工单列表ID，多个以英文逗号(,)分割
     * @return
     */
    @Override
    public boolean deletePmsWorkOrders(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的工单列表数据为空");
        // 逻辑删除
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }

}
