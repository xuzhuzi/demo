package com.xuzhuzi.exceptionhandle.exception;

import com.xuzhuzi.exceptionhandle.enums.IResponseEnum;
import lombok.Data;

@Data
public class BaseException extends RuntimeException {
	private IResponseEnum responseEnum;
	Object[] args;

	public BaseException(IResponseEnum responseEnum, Object[] args, String message) {
		super(message);
		this.responseEnum = responseEnum;
		this.args = args;
	}

	public BaseException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
		super(message, cause);
		this.responseEnum = responseEnum;
		this.args = args;
	}
}
