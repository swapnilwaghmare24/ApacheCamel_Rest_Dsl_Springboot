package com.bridgelabz.apachecameldsl.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridgelabz.apachecameldsl.dto.OrderDemoDto;
import com.bridgelabz.apachecameldsl.orderdemoservice.OrderDemoService;

@Component
public class OrderProcessor implements Processor{

	@Autowired
	OrderDemoService service;
	@Override
	public void process(Exchange exchange) throws Exception {
		
		service.addOrder(exchange.getIn().getBody(OrderDemoDto.class));
		
		
	}

}
