package com.zhongkai.common.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: ResponseException
 * @Description: 自定义异常类
 * @date 2018/1/15
 * @Copyright © 2017北京数人科技有限公司
 */
public class ResponseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private int status;

    private String message;

    private String body;

    public ResponseException(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseException(int status, String message, String content) {
        this.status = status;
        this.message = message;
        this.body = content;
    }

    @Override
    public String getMessage() {
        if (StringUtils.isBlank(message)) {
            message = body;
        }

        return message + " (http status: " + status + ")";
    }

    public String getResponseMessage() {
        return this.message;
    }

    public int getResponseStatus() {
        return this.status;
    }

    public String getResponseBody() {

        return this.body;
    }

    @Override
    public String toString() {
        if (StringUtils.isBlank(message)) {
            message = body;
        }
        return message + " (http status: " + status + ")";
    }
}
