package com.siddharth.sample;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class HelloWorld {
	
	public static void main(String[] args) throws Exception {
		
		CamelContext camelCtx = new DefaultCamelContext();
		
		camelCtx.addRoutes(new HellowWorldRoute());
		
		camelCtx.start();
	}

}
