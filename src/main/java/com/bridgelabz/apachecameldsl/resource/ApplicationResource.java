package com.bridgelabz.apachecameldsl.resource;


import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.bridgelabz.apachecameldsl.dto.OrderDemoDto;
import com.bridgelabz.apachecameldsl.model.OrderDemoModel;
import com.bridgelabz.apachecameldsl.orderdemoservice.OrderDemoService;
import com.bridgelabz.apachecameldsl.processor.OrderProcessor;

@Component
public class ApplicationResource extends RouteBuilder{

	@Autowired
	OrderDemoService service;
	@BeanInject
	OrderProcessor processor;
	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").port(9090).host("localhost").bindingMode(RestBindingMode.json);
		rest().get("/hello").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(constant("Welcome"));
		
		rest().get("/getOrders").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(()->service.getOrders());
		rest().post("/addOrder").produces(MediaType.APPLICATION_JSON_VALUE).type(OrderDemoDto.class).outType(OrderDemoModel.class).route().process(processor);


	}

}
