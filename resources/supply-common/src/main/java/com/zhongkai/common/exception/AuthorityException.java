package com.zhongkai.common.exception;
/**
 * 权限不足异常类
 * @author shurenkeji
 *
 */
public class AuthorityException extends ResponseException {

	public AuthorityException(int status, String message) {
		super(status, message);
	}

	public AuthorityException(int status, String message, String content) {
		super(status, message, content);
	}
}
