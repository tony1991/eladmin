package me.zhengjie.modules.merchant.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import me.zhengjie.annotation.Query;

/**
* @author tony
* @date 2019-08-07
*/
@Data
public class MchInfoQueryCriteria{

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String mchId;

    // 精确
    @Query
    private String state;
}