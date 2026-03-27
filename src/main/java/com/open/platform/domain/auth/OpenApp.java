package com.open.platform.domain.auth;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 第三方应用表
 * @TableName open_app
 */
@TableName(value ="open_app")
@Data
public class OpenApp implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 公司名称
     */
    private String appName;

    /**
     * 唯一 ID
     */
    private String securityId;

    /**
     * 密钥
     */
    private String secretKey;

    /**
     * IP 白名单
     */
    private String ipWhitelist;

    /**
     * 1启用 0禁用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}