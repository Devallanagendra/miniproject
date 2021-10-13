package com.main.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Order;
import com.main.repository.OrderDao;

@Service
@Transactional
public class OrderImplementation implements OrderService {
	@Autowired
	OrderDao repo;

	public List<Order> viewAllOrders() {
		return repo.findAll();
	}

	public void createProduct(Order order) {
		repo.save(order);
	}

	public Optional<Order> viewAOrder(int id) {
		return repo.findById(id);
	}

}
