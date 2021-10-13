package com.main.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.main.model.Product;

@FeignClient(value = "product-service")
public interface FeignController {
	@GetMapping("/product/viewAProduct/{id}")
	public Product viewAProduct(@PathVariable("id") int id);

}
