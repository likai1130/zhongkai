package com.zhongkai.common.exception;

/**
 * @ClassName: ParameterErrorExecption
 * @Description: 参数错误异常处理
 * @date 2017/12/18
 * @Copyright © 2017北京数人科技有限公司
 */
public class ParameterErrorExecption extends ResponseException{

    public ParameterErrorExecption(int status, String message) {
        super(status, message);
    }

    public ParameterErrorExecption(int status, String message, String content) {
        super(status, message, content);
    }
}
