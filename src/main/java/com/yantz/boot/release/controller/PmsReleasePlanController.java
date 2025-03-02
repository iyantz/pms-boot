package com.yantz.boot.release.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yantz.boot.common.result.PageResult;
import com.yantz.boot.common.result.Result;
import com.yantz.boot.release.model.form.PmsReleasePlanForm;
import com.yantz.boot.release.model.query.PmsReleasePlanQuery;
import com.yantz.boot.release.model.vo.PmsReleasePlanVO;
import com.yantz.boot.release.service.PmsReleasePlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 发布计划前端控制层
 *
 * @author yantz
 * @since 2025-03-02 13:40
 */
@Tag(name = "20.发布计划接口")
@RestController
@RequestMapping("/api/v1/pmsReleasePlans")
@RequiredArgsConstructor
public class PmsReleasePlanController  {

    private final PmsReleasePlanService pmsReleasePlanService;

    @Operation(summary = "发布计划分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('release:pmsReleasePlan:query')")
    public PageResult<PmsReleasePlanVO> getPmsReleasePlanPage(PmsReleasePlanQuery queryParams ) {
        IPage<PmsReleasePlanVO> result = pmsReleasePlanService.getPmsReleasePlanPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增发布计划")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('release:pmsReleasePlan:add')")
    public Result<Void> savePmsReleasePlan(@RequestBody @Valid PmsReleasePlanForm formData ) {
        boolean result = pmsReleasePlanService.savePmsReleasePlan(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取发布计划表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('release:pmsReleasePlan:edit')")
    public Result<PmsReleasePlanForm> getPmsReleasePlanForm(
        @Parameter(description = "发布计划ID") @PathVariable Long id
    ) {
        PmsReleasePlanForm formData = pmsReleasePlanService.getPmsReleasePlanFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改发布计划")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('release:pmsReleasePlan:edit')")
    public Result<Void> updatePmsReleasePlan(
            @Parameter(description = "发布计划ID") @PathVariable Long id,
            @RequestBody @Validated PmsReleasePlanForm formData
    ) {
        boolean result = pmsReleasePlanService.updatePmsReleasePlan(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除发布计划")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('release:pmsReleasePlan:delete')")
    public Result<Void> deletePmsReleasePlans(
        @Parameter(description = "发布计划ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = pmsReleasePlanService.deletePmsReleasePlans(ids);
        return Result.judge(result);
    }
}
