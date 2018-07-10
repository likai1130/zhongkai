package com.zhongkai.common.exception;


/**
 * @ClassName: NameRepetitionException
 * @Description: 命名重复异常
 * @date 2017/12/18
 * @Copyright © 2017北京数人科技有限公司
 */
public class NameRepetitionException extends ResponseException{

    public NameRepetitionException(int status, String message) {
        super(status, message);
    }

    public NameRepetitionException(int status, String message, String content) {
        super(status, message, content);
    }
}
