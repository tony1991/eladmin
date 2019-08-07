package me.zhengjie.modules.merchant.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;


/**
* @author tony
* @date 2019-08-07
*/
@Data
public class MchInfoDTO implements Serializable {

    // 商户id
    private String mchId;

    // 名称
    private String name;

    // 类型
    private String type;

    // 请求密钥
    private String reqKey;

    // 加密密钥
    private String resKey;

    // 商户状态：0-停止使用、1使用中
    private String state;

    // 创建时间
    private Timestamp createTime;

    // 更新时间
    private Timestamp updateTime;
}