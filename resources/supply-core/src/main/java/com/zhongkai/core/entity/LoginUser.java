package com.zhongkai.core.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName: LoginUser
 * @Description: 用户登录记录
 * @date 2018/1/26
 * @Copyright © 2017北京数人科技有限公司
 */
@Entity
@Table(name = "login_user")
public class LoginUser implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private String userName;
    @NotBlank
    private String token;
    @NotBlank
    private String expireAt ;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(String expireAt) {
        this.expireAt = expireAt;
    }

    public LoginUser(String userName, String token, String expireAt) {
        this.userName = userName;
        this.token = token;
        this.expireAt = expireAt;
    }

    public LoginUser() {
    }
}
