package com.main.service;

import java.util.List;
import java.util.Optional;

import com.main.model.Order;

public interface OrderService {

	List<Order> viewAllOrders();


	void createProduct(Order order);


	Optional<Order> viewAOrder(int id);



}
