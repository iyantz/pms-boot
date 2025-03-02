package com.yantz.boot.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yantz.boot.common.result.PageResult;
import com.yantz.boot.common.result.Result;
import com.yantz.boot.project.model.form.PmsRequirementForm;
import com.yantz.boot.project.model.query.PmsRequirementQuery;
import com.yantz.boot.project.model.vo.PmsRequirementVO;
import com.yantz.boot.project.service.PmsRequirementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 需求信息前端控制层
 *
 * @author yantz
 * @since 2025-03-02 13:22
 */
@Tag(name = "16.需求信息接口")
@RestController
@RequestMapping("/api/v1/pmsRequirements")
@RequiredArgsConstructor
public class PmsRequirementController  {

    private final PmsRequirementService pmsRequirementService;

    @Operation(summary = "需求信息分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('project:pmsRequirement:query')")
    public PageResult<PmsRequirementVO> getPmsRequirementPage(PmsRequirementQuery queryParams ) {
        IPage<PmsRequirementVO> result = pmsRequirementService.getPmsRequirementPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增需求信息")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('project:pmsRequirement:add')")
    public Result<Void> savePmsRequirement(@RequestBody @Valid PmsRequirementForm formData ) {
        boolean result = pmsRequirementService.savePmsRequirement(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取需求信息表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('project:pmsRequirement:edit')")
    public Result<PmsRequirementForm> getPmsRequirementForm(
        @Parameter(description = "需求信息ID") @PathVariable Long id
    ) {
        PmsRequirementForm formData = pmsRequirementService.getPmsRequirementFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改需求信息")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('project:pmsRequirement:edit')")
    public Result<Void> updatePmsRequirement(
            @Parameter(description = "需求信息ID") @PathVariable Long id,
            @RequestBody @Validated PmsRequirementForm formData
    ) {
        boolean result = pmsRequirementService.updatePmsRequirement(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除需求信息")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('project:pmsRequirement:delete')")
    public Result<Void> deletePmsRequirements(
        @Parameter(description = "需求信息ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = pmsRequirementService.deletePmsRequirements(ids);
        return Result.judge(result);
    }
}
