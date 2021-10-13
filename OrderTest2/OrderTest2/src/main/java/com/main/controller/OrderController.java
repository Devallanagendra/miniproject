package com.main.controller;

import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Order;
import com.main.model.Product;
import com.main.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {
	@Autowired
	OrderService psrv;
	@Autowired
	private FeignController myFeignClient;

	@GetMapping("viewAllOrders")
	public ResponseEntity<List<Order>> viewAllOrders() {
		List<Order> uList = psrv.viewAllOrders();
		if (!uList.isEmpty())
			return new ResponseEntity<>(uList, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@PostMapping("createOrder/{id}")
	public ResponseEntity<String> createProduct(@PathVariable("id") int id, @RequestBody Order order) {
		System.out.println("))))))))))))))))))))))))");
		Product option = myFeignClient.viewAProduct(id);
		System.out.println(option);


		if (option != null) {
			psrv.createProduct(order);
			return new ResponseEntity<>("Created", HttpStatus.CREATED);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@GetMapping("/viewAOrder/{id}")
	public ResponseEntity<Optional<Order>> viewAProduct(@PathVariable("id") int id) {
		Optional<Order> option = psrv.viewAOrder(id);
		if (option.isPresent())
			return new ResponseEntity<>(option, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
