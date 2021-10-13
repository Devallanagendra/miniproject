package com.main.service;

import java.util.List;
import java.util.Optional;

import com.main.model.Product;

public interface ProductService {


	List<Product> viewAllProducts();

	Product createProduct(Product prod);


	Optional<Product> viewAProduct(int id);

}
