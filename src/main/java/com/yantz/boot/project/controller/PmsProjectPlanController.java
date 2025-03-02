package com.yantz.boot.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yantz.boot.common.result.PageResult;
import com.yantz.boot.common.result.Result;
import com.yantz.boot.project.model.form.PmsProjectPlanForm;
import com.yantz.boot.project.model.query.PmsProjectPlanQuery;
import com.yantz.boot.project.model.vo.PmsProjectPlanVO;
import com.yantz.boot.project.service.PmsProjectPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 项目计划前端控制层
 *
 * @author yantz
 * @since 2025-03-02 14:02
 */
@Tag(name = "15.项目计划接口")
@RestController
@RequestMapping("/api/v1/pmsProjectPlans")
@RequiredArgsConstructor
public class PmsProjectPlanController  {

    private final PmsProjectPlanService pmsProjectPlanService;

    @Operation(summary = "项目计划分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('project:pmsProjectPlan:query')")
    public PageResult<PmsProjectPlanVO> getPmsProjectPlanPage(PmsProjectPlanQuery queryParams ) {
        IPage<PmsProjectPlanVO> result = pmsProjectPlanService.getPmsProjectPlanPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增项目计划")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('project:pmsProjectPlan:add')")
    public Result<Void> savePmsProjectPlan(@RequestBody @Valid PmsProjectPlanForm formData ) {
        boolean result = pmsProjectPlanService.savePmsProjectPlan(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取项目计划表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('project:pmsProjectPlan:edit')")
    public Result<PmsProjectPlanForm> getPmsProjectPlanForm(
        @Parameter(description = "项目计划ID") @PathVariable Long id
    ) {
        PmsProjectPlanForm formData = pmsProjectPlanService.getPmsProjectPlanFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改项目计划")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('project:pmsProjectPlan:edit')")
    public Result<Void> updatePmsProjectPlan(
            @Parameter(description = "项目计划ID") @PathVariable Long id,
            @RequestBody @Validated PmsProjectPlanForm formData
    ) {
        boolean result = pmsProjectPlanService.updatePmsProjectPlan(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除项目计划")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('project:pmsProjectPlan:delete')")
    public Result<Void> deletePmsProjectPlans(
        @Parameter(description = "项目计划ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = pmsProjectPlanService.deletePmsProjectPlans(ids);
        return Result.judge(result);
    }
}
