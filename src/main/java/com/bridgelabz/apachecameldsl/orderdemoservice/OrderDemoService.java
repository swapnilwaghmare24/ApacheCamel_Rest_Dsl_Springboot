package com.bridgelabz.apachecameldsl.orderdemoservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.apachecameldsl.dto.OrderDemoDto;
import com.bridgelabz.apachecameldsl.model.OrderDemoModel;
import com.bridgelabz.apachecameldsl.repository.OrderDemoRepo;

@Service
public class OrderDemoService {
	@Autowired
	OrderDemoRepo repo;
	public OrderDemoModel addOrder(OrderDemoDto orderDemoDto) {
		OrderDemoModel dataDemoModel=new OrderDemoModel(orderDemoDto);
		return repo.save(dataDemoModel);
		
	}
	
	public List<OrderDemoModel> getOrders() {
		return repo.findAll();
	}

}
