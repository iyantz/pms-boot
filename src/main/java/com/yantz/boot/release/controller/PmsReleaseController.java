package com.yantz.boot.release.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yantz.boot.common.result.PageResult;
import com.yantz.boot.common.result.Result;
import com.yantz.boot.release.model.form.PmsReleaseForm;
import com.yantz.boot.release.model.query.PmsReleaseQuery;
import com.yantz.boot.release.model.vo.PmsReleaseVO;
import com.yantz.boot.release.service.PmsReleaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 发布列表前端控制层
 *
 * @author yantz
 * @since 2025-03-02 13:44
 */
@Tag(name = "21.发布列表接口")
@RestController
@RequestMapping("/api/v1/pmsReleases")
@RequiredArgsConstructor
public class PmsReleaseController  {

    private final PmsReleaseService pmsReleaseService;

    @Operation(summary = "发布列表分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('release:pmsRelease:query')")
    public PageResult<PmsReleaseVO> getPmsReleasePage(PmsReleaseQuery queryParams ) {
        IPage<PmsReleaseVO> result = pmsReleaseService.getPmsReleasePage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增发布列表")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('release:pmsRelease:add')")
    public Result<Void> savePmsRelease(@RequestBody @Valid PmsReleaseForm formData ) {
        boolean result = pmsReleaseService.savePmsRelease(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取发布列表表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('release:pmsRelease:edit')")
    public Result<PmsReleaseForm> getPmsReleaseForm(
        @Parameter(description = "发布列表ID") @PathVariable Long id
    ) {
        PmsReleaseForm formData = pmsReleaseService.getPmsReleaseFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改发布列表")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('release:pmsRelease:edit')")
    public Result<Void> updatePmsRelease(
            @Parameter(description = "发布列表ID") @PathVariable Long id,
            @RequestBody @Validated PmsReleaseForm formData
    ) {
        boolean result = pmsReleaseService.updatePmsRelease(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除发布列表")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('release:pmsRelease:delete')")
    public Result<Void> deletePmsReleases(
        @Parameter(description = "发布列表ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = pmsReleaseService.deletePmsReleases(ids);
        return Result.judge(result);
    }
}
