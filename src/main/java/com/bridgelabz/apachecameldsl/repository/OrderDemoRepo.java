package com.bridgelabz.apachecameldsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.apachecameldsl.model.OrderDemoModel;

@Repository
public interface OrderDemoRepo extends JpaRepository<OrderDemoModel,Integer> {

}