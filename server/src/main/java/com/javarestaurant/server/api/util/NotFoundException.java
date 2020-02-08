package com.javarestaurant.server.api.util;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-29T13:13:37.274Z[GMT]")
public class NotFoundException extends ApiException {
	private int code;

	public NotFoundException(int code, String msg) {
		super(code, msg);
		this.code = code;
	}
}
