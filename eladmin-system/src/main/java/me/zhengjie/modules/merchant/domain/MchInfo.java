package me.zhengjie.modules.merchant.domain;

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
@Table(name="mch_info")
public class MchInfo implements Serializable {

    // 商户id
    @Id
    @Column(name = "mch_id")
    private String mchId;

    // 名称
    @Column(name = "name",nullable = false)
    private String name;

    // 类型
    @Column(name = "type",nullable = false)
    private String type;

    // 请求密钥
    @Column(name = "req_key",nullable = false)
    private String reqKey;

    // 加密密钥
    @Column(name = "res_key",nullable = false)
    private String resKey;

    // 商户状态：0-停止使用、1使用中
    @Column(name = "state",nullable = false)
    private String state;

    // 创建时间
    @Column(name = "create_time",nullable = false)
    private Timestamp createTime;

    // 更新时间
    @Column(name = "update_time",nullable = false)
    private Timestamp updateTime;

    public void copy(MchInfo source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}