package me.zhengjie.modules.order.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.order.domain.TPayOrder;
import me.zhengjie.modules.order.service.dto.TPayOrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author tony
* @date 2019-08-07
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TPayOrderMapper extends EntityMapper<TPayOrderDTO, TPayOrder> {

}