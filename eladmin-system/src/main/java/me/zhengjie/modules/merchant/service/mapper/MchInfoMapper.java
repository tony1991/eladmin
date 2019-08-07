package me.zhengjie.modules.merchant.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.merchant.domain.MchInfo;
import me.zhengjie.modules.merchant.service.dto.MchInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author tony
* @date 2019-08-07
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MchInfoMapper extends EntityMapper<MchInfoDTO, MchInfo> {

}