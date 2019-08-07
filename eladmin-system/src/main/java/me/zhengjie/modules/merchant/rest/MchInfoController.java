package me.zhengjie.modules.merchant.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.merchant.domain.MchInfo;
import me.zhengjie.modules.merchant.service.MchInfoService;
import me.zhengjie.modules.merchant.service.dto.MchInfoQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

/**
* @author tony
* @date 2019-08-07
*/
@Api(tags = "MchInfo管理")
@RestController
@RequestMapping("api")
public class MchInfoController {

    @Autowired
    private MchInfoService mchInfoService;

    @Log("查询MchInfo")
    @ApiOperation(value = "查询MchInfo")
    @GetMapping(value = "/mchInfo")
    @PreAuthorize("hasAnyRole('ADMIN','MCHINFO_ALL','MCHINFO_SELECT')")
    public ResponseEntity getMchInfos(MchInfoQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(mchInfoService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增MchInfo")
    @ApiOperation(value = "新增MchInfo")
    @PostMapping(value = "/mchInfo")
    @PreAuthorize("hasAnyRole('ADMIN','MCHINFO_ALL','MCHINFO_CREATE')")
    public ResponseEntity create(@Validated @RequestBody MchInfo resources){
        return new ResponseEntity(mchInfoService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改MchInfo")
    @ApiOperation(value = "修改MchInfo")
    @PutMapping(value = "/mchInfo")
    @PreAuthorize("hasAnyRole('ADMIN','MCHINFO_ALL','MCHINFO_EDIT')")
    public ResponseEntity update(@Validated @RequestBody MchInfo resources){
        mchInfoService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除MchInfo")
    @ApiOperation(value = "删除MchInfo")
    @DeleteMapping(value = "/mchInfo/{mchId}")
    @PreAuthorize("hasAnyRole('ADMIN','MCHINFO_ALL','MCHINFO_DELETE')")
    public ResponseEntity delete(@PathVariable String mchId){
        mchInfoService.delete(mchId);
        return new ResponseEntity(HttpStatus.OK);
    }
}