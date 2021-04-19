package com.siddharth.sample5;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class RestApiDemo {
	
	public static void main(String[] args) throws Exception {
		CamelContext ctx = new DefaultCamelContext();
		ctx.addRoutes(new RestApiRoute());
		ctx.start();
	}


}
