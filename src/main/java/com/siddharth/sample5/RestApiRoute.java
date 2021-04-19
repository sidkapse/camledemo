package com.siddharth.sample5;

import org.apache.camel.builder.RouteBuilder;

public class RestApiRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		restConfiguration().component("restlet")
		.host("localhost").port("8080");
		
		rest("/api/people")
			.get().route().setBody(constant("Sid,Rupali,Quynh"));
	}

}
