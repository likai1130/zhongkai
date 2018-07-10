package com.zhongkai.common.exception;
/**
 * 权限不足异常类
 * @author shurenkeji
 *
 */
public class OauthTokensException extends ResponseException {

	public OauthTokensException(int status, String message) {
		super(status, message);
	}

	public OauthTokensException(int status, String message, String content) {
		super(status, message, content);
	}
}
