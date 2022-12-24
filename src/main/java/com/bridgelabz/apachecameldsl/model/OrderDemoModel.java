package com.bridgelabz.apachecameldsl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.bridgelabz.apachecameldsl.dto.OrderDemoDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OrderDemoModel {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;
	
	public OrderDemoModel(OrderDemoDto orderDemoDto)
	{
		this.name=orderDemoDto.getName();
		this.price=orderDemoDto.getPrice();
	}
	
	

}
