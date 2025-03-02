package com.yantz.boot.release.controller;

import com.yantz.boot.release.service.PmsReleaseContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yantz.boot.release.model.form.PmsReleaseContentForm;
import com.yantz.boot.release.model.query.PmsReleaseContentQuery;
import com.yantz.boot.release.model.vo.PmsReleaseContentVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yantz.boot.common.result.PageResult;
import com.yantz.boot.common.result.Result;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

/**
 * 发布内容前端控制层
 *
 * @author yantz
 * @since 2025-03-02 13:47
 */
@Tag(name = "发布内容接口")
@RestController
@RequestMapping("/api/v1/pmsReleaseContents")
@RequiredArgsConstructor
public class PmsReleaseContentController  {

    private final PmsReleaseContentService pmsReleaseContentService;

    @Operation(summary = "发布内容分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('release:pmsReleaseContent:query')")
    public PageResult<PmsReleaseContentVO> getPmsReleaseContentPage(PmsReleaseContentQuery queryParams ) {
        IPage<PmsReleaseContentVO> result = pmsReleaseContentService.getPmsReleaseContentPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增发布内容")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('release:pmsReleaseContent:add')")
    public Result<Void> savePmsReleaseContent(@RequestBody @Valid PmsReleaseContentForm formData ) {
        boolean result = pmsReleaseContentService.savePmsReleaseContent(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取发布内容表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('release:pmsReleaseContent:edit')")
    public Result<PmsReleaseContentForm> getPmsReleaseContentForm(
        @Parameter(description = "发布内容ID") @PathVariable Long id
    ) {
        PmsReleaseContentForm formData = pmsReleaseContentService.getPmsReleaseContentFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改发布内容")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('release:pmsReleaseContent:edit')")
    public Result<Void> updatePmsReleaseContent(
            @Parameter(description = "发布内容ID") @PathVariable Long id,
            @RequestBody @Validated PmsReleaseContentForm formData
    ) {
        boolean result = pmsReleaseContentService.updatePmsReleaseContent(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除发布内容")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('release:pmsReleaseContent:delete')")
    public Result<Void> deletePmsReleaseContents(
        @Parameter(description = "发布内容ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = pmsReleaseContentService.deletePmsReleaseContents(ids);
        return Result.judge(result);
    }
}
