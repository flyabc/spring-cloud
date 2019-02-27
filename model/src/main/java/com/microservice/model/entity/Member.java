package com.microservice.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author mybatis-plus
 * @since 2019-02-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_member")
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.UUID)
    private String id;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册时间
     */
    private LocalDateTime regTime;

    /**
     * token
     */
    private String token;

    /**
     * 上一次登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 账户状态(0-无效;1-有效;2-其他)
     */
    private Integer memberStatus;

    /**
     * 账户持有人姓名
     */
    private String shortName;

    /**
     * 账户类型(1-企业;2-个人;3-其他)
     */
    private Integer memberType;

    /**
     * 用户手机号
     */
    private String memberPhone;

    /**
     * 操作人id
     */
    private String operatorId;

    /**
     * 平台id
     */
    @TableField("app_Id")
    private Integer appId;

    /**
     * 用户rsa公钥地址
     */
    private String rsaPubPath;

    /**
     * 用户dsa公钥地址
     */
    private String dsaPubPath;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用户绑定邮箱
     */
    private String memberEmail;


}
