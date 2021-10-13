package com.main.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Product;
import com.main.repository.ProductRepository;

@Service
@Transactional
public class ProductImplementation implements ProductService {
	@Autowired
	ProductRepository repo;

	public List<Product> viewAllProducts() {
		return repo.findAll();
	}

	public Product createProduct(Product prod) {
		return repo.save(prod);
	}

	public Optional<Product> viewAProduct(int id) {

		return repo.findById(id);
	}

}
