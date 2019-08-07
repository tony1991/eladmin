package me.zhengjie.modules.order.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author tony
* @date 2019-08-07
*/
@Entity
@Data
@Table(name="t_pay_order")
public class TPayOrder implements Serializable {

    // 支付订单号
    @Id
    @Column(name = "pay_order_id")
    private String payOrderId;

    // 商户ID
    @Column(name = "mch_id",nullable = false)
    private String mchId;

    // 商户订单号
    @Column(name = "mch_order_no",nullable = false)
    private String mchOrderNo;

    // 渠道ID
    @Column(name = "channel_id",nullable = false)
    private String channelId;

    // 渠道商户ID
    @Column(name = "channel_mch_id",nullable = false)
    private String channelMchId;

    // 渠道订单号
    @Column(name = "channel_order_no")
    private String channelOrderNo;

    // 支付金额
    @Column(name = "amount",nullable = false)
    private Long amount;

    // 三位货币代码
    @Column(name = "currency",nullable = false)
    private String currency;

    // 支付状态
    @Column(name = "order_status",nullable = false)
    private String orderStatus;

    // 客户端IP
    @Column(name = "client_ip")
    private String clientIp;

    // 终端设备号
    @Column(name = "terminal_code",nullable = false)
    private String terminalCode;

    // 支付方式
    @Column(name = "pay_mode",nullable = false)
    private String payMode;

    // 商品标题
    @Column(name = "subject",nullable = false)
    private String subject;

    // 商品描述信息
    @Column(name = "body",nullable = false)
    private String body;

    // 特定渠道发起时额外参数
    @Column(name = "extra")
    private String extra;

    // 商户门店编号
    @Column(name = "store_id")
    private String storeId;

    // 商户操作员编号
    @Column(name = "operator_id")
    private String operatorId;

    // 付款用户编号
    @Column(name = "user_id")
    private String userId;

    // 渠道支付错误码
    @Column(name = "err_code")
    private String errCode;

    // 渠道支付错误描述
    @Column(name = "err_msg")
    private String errMsg;

    // 商户保留字段
    @Column(name = "reserve_params")
    private String reserveParams;

    // 通知地址
    @Column(name = "notify_url")
    private String notifyUrl;

    // 通知次数
    @Column(name = "notify_count")
    private Integer notifyCount;

    // 最后一次通知时间
    @Column(name = "last_notify_time")
    private Long lastNotifyTime;

    // 订单失效时间
    @Column(name = "expire_time")
    private Long expireTime;

    // 订单支付成功时间
    @Column(name = "pay_succ_time")
    private Timestamp paySuccTime;

    // 订单退款时间
    @Column(name = "refund_time")
    private Timestamp refundTime;

    // 创建时间
    @Column(name = "create_time",nullable = false)
    private Timestamp createTime;

    // 更新时间
    @Column(name = "update_time",nullable = false)
    private Timestamp updateTime;

    public void copy(TPayOrder source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}