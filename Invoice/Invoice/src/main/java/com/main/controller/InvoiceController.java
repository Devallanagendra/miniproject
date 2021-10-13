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

import com.main.model.Invoice;
import com.main.model.Order;
import com.main.model.Product;
import com.main.service.InvoiceService;

@RequestMapping("invoice")
@RestController
public class InvoiceController {
	@Autowired
	InvoiceService osrv;
	@Autowired
	private FeignController myFeignClient;
	@Autowired
	private ProductController myFeignClient1;

	@GetMapping("viewAllInvoices")
	public ResponseEntity<List<Invoice>> viewAllInvoices() {
		List<Invoice> uList = osrv.viewAllInvoices();
		if (!uList.isEmpty())
			return new ResponseEntity<>(uList, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@PostMapping("createInvoice/{id}")
	public ResponseEntity<String> createInvoice(@PathVariable("id") int id, @RequestBody Invoice invoice) {
		Optional<Order> opt = myFeignClient.viewAOrder(id);
		if (opt.get().getStatus().equals("Confirmed")) {

			int quant = opt.get().getQuantity();
			int p_id = opt.get().getP_id();
			System.out.println(quant);
			Product option = myFeignClient1.viewAProduct(p_id);
			if (option != null) {
				double price = option.getPrice();
				System.out.println("****************************");
				double total = price * quant;
				System.out.println(total);
				invoice.setTotal(total);
				osrv.createInvoice(invoice);
				return new ResponseEntity<>("Invoice generated successfully", HttpStatus.CREATED);
			}

		}
		return new ResponseEntity<String>("Failed to generate Invoice for order status- " + opt.get().getStatus(),
				HttpStatus.OK);

	}

	@GetMapping("/viewAInvoice/{id}")
	public ResponseEntity<Optional<Invoice>> viewAInvoice(@PathVariable("id") int id) {
		Optional<Invoice> option = osrv.viewAInvoice(id);
		if (option.isPresent())
			return new ResponseEntity<>(option, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
