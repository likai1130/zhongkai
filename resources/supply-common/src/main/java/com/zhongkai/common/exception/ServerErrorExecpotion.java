package com.zhongkai.common.exception;

/**
 * @ClassName: ServerErrorExecpotion
 * @Description: 内部服务故障
 * @date 2018/1/16
 * @Copyright © 2017北京数人科技有限公司
 */
public class ServerErrorExecpotion extends ResponseException {
    public ServerErrorExecpotion(int status, String message) {
        super(status, message);
    }

    public ServerErrorExecpotion(int status, String message, String content) {
        super(status, message, content);
    }
}
