package me.zhengjie.modules.order.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import me.zhengjie.annotation.Query;

/**
* @author tony
* @date 2019-08-07
*/
@Data
public class TPayOrderQueryCriteria{

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String payOrderId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String mchId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String mchOrderNo;

    // 精确
    @Query
    private String channelId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String channelOrderNo;

    // 精确
    @Query
    private String orderStatus;
}