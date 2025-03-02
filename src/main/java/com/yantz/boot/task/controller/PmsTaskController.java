package com.yantz.boot.task.controller;

import com.yantz.boot.task.service.PmsTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yantz.boot.task.model.form.PmsTaskForm;
import com.yantz.boot.task.model.query.PmsTaskQuery;
import com.yantz.boot.task.model.vo.PmsTaskVO;
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
 * 任务列表前端控制层
 *
 * @author yantz
 * @since 2025-03-02 13:34
 */
@Tag(name = "任务列表接口")
@RestController
@RequestMapping("/api/v1/pmsTasks")
@RequiredArgsConstructor
public class PmsTaskController  {

    private final PmsTaskService pmsTaskService;

    @Operation(summary = "任务列表分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('task:pmsTask:query')")
    public PageResult<PmsTaskVO> getPmsTaskPage(PmsTaskQuery queryParams ) {
        IPage<PmsTaskVO> result = pmsTaskService.getPmsTaskPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增任务列表")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('task:pmsTask:add')")
    public Result<Void> savePmsTask(@RequestBody @Valid PmsTaskForm formData ) {
        boolean result = pmsTaskService.savePmsTask(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取任务列表表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('task:pmsTask:edit')")
    public Result<PmsTaskForm> getPmsTaskForm(
        @Parameter(description = "任务列表ID") @PathVariable Long id
    ) {
        PmsTaskForm formData = pmsTaskService.getPmsTaskFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改任务列表")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('task:pmsTask:edit')")
    public Result<Void> updatePmsTask(
            @Parameter(description = "任务列表ID") @PathVariable Long id,
            @RequestBody @Validated PmsTaskForm formData
    ) {
        boolean result = pmsTaskService.updatePmsTask(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除任务列表")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('task:pmsTask:delete')")
    public Result<Void> deletePmsTasks(
        @Parameter(description = "任务列表ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = pmsTaskService.deletePmsTasks(ids);
        return Result.judge(result);
    }
}
