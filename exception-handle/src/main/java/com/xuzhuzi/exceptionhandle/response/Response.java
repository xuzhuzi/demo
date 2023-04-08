package com.xuzhuzi.exceptionhandle.response;

import lombok.Data;

@Data
public class Response<T> {
	private int code;
	private String message;
	private T data;

	public Response(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public Response(int code, T data) {
		this.code = code;
		this.data = data;
	}
}
