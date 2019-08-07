package me.zhengjie.modules.order.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.order.domain.TPayOrder;
import me.zhengjie.modules.order.service.TPayOrderService;
import me.zhengjie.modules.order.service.dto.TPayOrderQueryCriteria;
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
@Api(tags = "TPayOrder管理")
@RestController
@RequestMapping("api")
public class TPayOrderController {

    @Autowired
    private TPayOrderService tPayOrderService;

    @Log("查询TPayOrder")
    @ApiOperation(value = "查询TPayOrder")
    @GetMapping(value = "/tPayOrder")
    @PreAuthorize("hasAnyRole('ADMIN','TPAYORDER_ALL','TPAYORDER_SELECT')")
    public ResponseEntity getTPayOrders(TPayOrderQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(tPayOrderService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增TPayOrder")
    @ApiOperation(value = "新增TPayOrder")
    @PostMapping(value = "/tPayOrder")
    @PreAuthorize("hasAnyRole('ADMIN','TPAYORDER_ALL','TPAYORDER_CREATE')")
    public ResponseEntity create(@Validated @RequestBody TPayOrder resources){
        return new ResponseEntity(tPayOrderService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改TPayOrder")
    @ApiOperation(value = "修改TPayOrder")
    @PutMapping(value = "/tPayOrder")
    @PreAuthorize("hasAnyRole('ADMIN','TPAYORDER_ALL','TPAYORDER_EDIT')")
    public ResponseEntity update(@Validated @RequestBody TPayOrder resources){
        tPayOrderService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除TPayOrder")
    @ApiOperation(value = "删除TPayOrder")
    @DeleteMapping(value = "/tPayOrder/{payOrderId}")
    @PreAuthorize("hasAnyRole('ADMIN','TPAYORDER_ALL','TPAYORDER_DELETE')")
    public ResponseEntity delete(@PathVariable String payOrderId){
        tPayOrderService.delete(payOrderId);
        return new ResponseEntity(HttpStatus.OK);
    }
}