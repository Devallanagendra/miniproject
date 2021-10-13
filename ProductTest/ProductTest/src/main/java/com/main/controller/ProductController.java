package com.main.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Product;
import com.main.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService psrv;

	@GetMapping("/viewAllProducts")
	public ResponseEntity<List<Product>> viewAllProducts() {
		List<Product> uList = psrv.viewAllProducts();
		if (!uList.isEmpty())
			return new ResponseEntity<>(uList, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@PostMapping("createProduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product prod) {
		Product prod1 = psrv.createProduct(prod);
		return new ResponseEntity<>(prod1, HttpStatus.CREATED);

	}

	@GetMapping("/viewAProduct/{id}")
	public ResponseEntity<Optional<Product>> viewAProduct(@PathVariable("id") int id) {

		Optional<Product> option = psrv.viewAProduct(id);
		if (option.isPresent())
			return new ResponseEntity<>(option, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}

}
