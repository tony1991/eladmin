package me.zhengjie.modules.order.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;


/**
* @author tony
* @date 2019-08-07
*/
@Data
public class TPayOrderDTO implements Serializable {

    // 支付订单号
    private String payOrderId;

    // 商户ID
    private String mchId;

    // 商户订单号
    private String mchOrderNo;

    // 渠道ID
    private String channelId;

    // 渠道商户ID
    private String channelMchId;

    // 渠道订单号
    private String channelOrderNo;

    // 支付金额
    private Long amount;

    // 三位货币代码
    private String currency;

    // 支付状态
    private String orderStatus;

    // 客户端IP
    private String clientIp;

    // 终端设备号
    private String terminalCode;

    // 支付方式
    private String payMode;

    // 商品标题
    private String subject;

    // 商品描述信息
    private String body;

    // 特定渠道发起时额外参数
    private String extra;

    // 商户门店编号
    private String storeId;

    // 商户操作员编号
    private String operatorId;

    // 付款用户编号
    private String userId;

    // 渠道支付错误码
    private String errCode;

    // 渠道支付错误描述
    private String errMsg;

    // 商户保留字段
    private String reserveParams;

    // 通知地址
    private String notifyUrl;

    // 通知次数
    private Integer notifyCount;

    // 最后一次通知时间
    private Long lastNotifyTime;

    // 订单失效时间
    private Long expireTime;

    // 订单支付成功时间
    private Timestamp paySuccTime;

    // 订单退款时间
    private Timestamp refundTime;

    // 创建时间
    private Timestamp createTime;

    // 更新时间
    private Timestamp updateTime;
}