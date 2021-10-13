package com.main.controller;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.main.model.Order;

@FeignClient(value = "order-service")
public interface FeignController {
	@GetMapping("/order/viewAOrder/{id}")
	public Optional<Order> viewAOrder(@PathVariable("id") int id);

}
