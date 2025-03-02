package com.yantz.boot.task.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yantz.boot.common.result.PageResult;
import com.yantz.boot.common.result.Result;
import com.yantz.boot.task.model.form.PmsDefectForm;
import com.yantz.boot.task.model.query.PmsDefectQuery;
import com.yantz.boot.task.model.vo.PmsDefectVO;
import com.yantz.boot.task.service.PmsDefectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 缺陷管理前端控制层
 *
 * @author yantz
 * @since 2025-03-02 13:31
 */
@Tag(name = "18.缺陷管理接口")
@RestController
@RequestMapping("/api/v1/pmsDefects")
@RequiredArgsConstructor
public class PmsDefectController  {

    private final PmsDefectService pmsDefectService;

    @Operation(summary = "缺陷管理分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('task:pmsDefect:query')")
    public PageResult<PmsDefectVO> getPmsDefectPage(PmsDefectQuery queryParams ) {
        IPage<PmsDefectVO> result = pmsDefectService.getPmsDefectPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增缺陷管理")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('task:pmsDefect:add')")
    public Result<Void> savePmsDefect(@RequestBody @Valid PmsDefectForm formData ) {
        boolean result = pmsDefectService.savePmsDefect(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取缺陷管理表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('task:pmsDefect:edit')")
    public Result<PmsDefectForm> getPmsDefectForm(
        @Parameter(description = "缺陷管理ID") @PathVariable Long id
    ) {
        PmsDefectForm formData = pmsDefectService.getPmsDefectFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改缺陷管理")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('task:pmsDefect:edit')")
    public Result<Void> updatePmsDefect(
            @Parameter(description = "缺陷管理ID") @PathVariable Long id,
            @RequestBody @Validated PmsDefectForm formData
    ) {
        boolean result = pmsDefectService.updatePmsDefect(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除缺陷管理")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('task:pmsDefect:delete')")
    public Result<Void> deletePmsDefects(
        @Parameter(description = "缺陷管理ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = pmsDefectService.deletePmsDefects(ids);
        return Result.judge(result);
    }
}
