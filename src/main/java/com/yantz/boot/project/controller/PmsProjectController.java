package com.yantz.boot.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yantz.boot.common.result.PageResult;
import com.yantz.boot.common.result.Result;
import com.yantz.boot.project.model.form.PmsProjectForm;
import com.yantz.boot.project.model.query.PmsProjectQuery;
import com.yantz.boot.project.model.vo.PmsProjectVO;
import com.yantz.boot.project.service.PmsProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 项目信息前端控制层
 *
 * @author yantz
 * @since 2025-03-02 14:04
 */
@Tag(name = "14.项目信息接口")
@RestController
@RequestMapping("/api/v1/pmsProjects")
@RequiredArgsConstructor
public class PmsProjectController  {

    private final PmsProjectService pmsProjectService;

    @Operation(summary = "项目信息分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPerm('project:pmsProject:query')")
    public PageResult<PmsProjectVO> getPmsProjectPage(PmsProjectQuery queryParams ) {
        IPage<PmsProjectVO> result = pmsProjectService.getPmsProjectPage(queryParams);
        return PageResult.success(result);
    }

    @Operation(summary = "新增项目信息")
    @PostMapping
    @PreAuthorize("@ss.hasPerm('project:pmsProject:add')")
    public Result<Void> savePmsProject(@RequestBody @Valid PmsProjectForm formData ) {
        boolean result = pmsProjectService.savePmsProject(formData);
        return Result.judge(result);
    }

    @Operation(summary = "获取项目信息表单数据")
    @GetMapping("/{id}/form")
    @PreAuthorize("@ss.hasPerm('project:pmsProject:edit')")
    public Result<PmsProjectForm> getPmsProjectForm(
        @Parameter(description = "项目信息ID") @PathVariable Long id
    ) {
        PmsProjectForm formData = pmsProjectService.getPmsProjectFormData(id);
        return Result.success(formData);
    }

    @Operation(summary = "修改项目信息")
    @PutMapping(value = "/{id}")
    @PreAuthorize("@ss.hasPerm('project:pmsProject:edit')")
    public Result<Void> updatePmsProject(
            @Parameter(description = "项目信息ID") @PathVariable Long id,
            @RequestBody @Validated PmsProjectForm formData
    ) {
        boolean result = pmsProjectService.updatePmsProject(id, formData);
        return Result.judge(result);
    }

    @Operation(summary = "删除项目信息")
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('project:pmsProject:delete')")
    public Result<Void> deletePmsProjects(
        @Parameter(description = "项目信息ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = pmsProjectService.deletePmsProjects(ids);
        return Result.judge(result);
    }
}
