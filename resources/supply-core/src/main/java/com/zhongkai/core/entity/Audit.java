package com.zhongkai.core.entity;

import com.zhongkai.common.util.TimeConversionUtil;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: Audit
 * @Description: 审计功能
 * @date 2018/2/5
 * @Copyright © 2017北京数人科技有限公司
 */
@Entity
@Table(name = "audit")
public class Audit {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private String requestUrl;

    private String requestType;

    private String requestMethod;

    private String parame;

    private String response;

    private String createAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getParame() {
        return parame;
    }

    public void setParame(String parame) {
        this.parame = parame;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        String date = TimeConversionUtil.timeStampToDate(createAt);
        this.createAt = date;
    }
}
