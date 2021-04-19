package com.siddharth.sample3;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.ProcessorEndpoint;

public class ProdAndConsumerExample {
	public static void main(String[] args) throws Exception {
		
		CamelContext camelCtx = new DefaultCamelContext();
		
		camelCtx.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				
				from("direct:start")
				.process(new Processor() {
					
					public void process(Exchange exchange) throws Exception {
						
						//System.out.println("I am the processor..");
						String message = exchange.getIn().getBody(String.class);
						message = message + " -By Siddharth Kapse";
						exchange.getMessage().setBody(message);
					}
				})
				.to("seda:end");
				
			}
		});
		
		camelCtx.start();
		
		ProducerTemplate producerTemplate = camelCtx.createProducerTemplate();
		
		producerTemplate.sendBody("direct:start", "Hello Everyone");
		
		ConsumerTemplate consumerTemplate = camelCtx.createConsumerTemplate();
		
		String message = consumerTemplate.receiveBody("seda:end", String.class);
		
		System.out.println(message);
		
	}
}
