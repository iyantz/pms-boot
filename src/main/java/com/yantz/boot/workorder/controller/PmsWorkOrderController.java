package com.yantz.boot.workorder.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yantz.boot.common.result.PageResult;
import com.yantz.boot.common.result.Result;
import com.yantz.boot.workorder.model.form.PmsWorkOrderForm;
import com.yantz.boot.workorder.model.query.PmsWorkOrderQuery;
import com.yantz.boot.workorder.model.vo.PmsWorkOrderVO;
import com.yantz.boot.workorder.service.PmsWorkOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 工单列表前端控制层
 *
 * @author yantz
 * @since 2025-03-02 13:37
 */
@Tag(name = "19.工单列表接口")
@RestController
@RequestMapping("/api/v1/pmsWorkOrders")
@RequiredArgsConstructor
public class PmsWorkOrderController  {

    private final PmsWorkOrderService pmsWorkOrderService;

    @Operation(summary = "工单列表分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('workorder:pmsWorkOrder:query')")
    public PageResult<PmsWorkOrderVO> getPmsWorkOrderPage(PmsWorkOrderQuery queryParams ) {
        IPage<PmsWorkOrderVO> result = pmsWorkOrderService.getPmsWorkOrderPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增工单列表")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('workorder:pmsWorkOrder:add')")
    public Result<Void> savePmsWorkOrder(@RequestBody @Valid PmsWorkOrderForm formData ) {
        boolean result = pmsWorkOrderService.savePmsWorkOrder(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取工单列表表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('workorder:pmsWorkOrder:edit')")
    public Result<PmsWorkOrderForm> getPmsWorkOrderForm(
        @Parameter(description = "工单列表ID") @PathVariable Long id
    ) {
        PmsWorkOrderForm formData = pmsWorkOrderService.getPmsWorkOrderFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改工单列表")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('workorder:pmsWorkOrder:edit')")
    public Result<Void> updatePmsWorkOrder(
            @Parameter(description = "工单列表ID") @PathVariable Long id,
            @RequestBody @Validated PmsWorkOrderForm formData
    ) {
        boolean result = pmsWorkOrderService.updatePmsWorkOrder(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除工单列表")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('workorder:pmsWorkOrder:delete')")
    public Result<Void> deletePmsWorkOrders(
        @Parameter(description = "工单列表ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = pmsWorkOrderService.deletePmsWorkOrders(ids);
        return Result.judge(result);
    }
}
