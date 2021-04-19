package com.siddharth.sample2;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileCopy {

	public static void main(String[] args) throws Exception {
		
		CamelContext camelCtx = new DefaultCamelContext();
		
		camelCtx.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("file:input_box?noop=true")
				.to("file:output_box");
			}
		});
		
		while(true)
			camelCtx.start();
		
	}
	
}
