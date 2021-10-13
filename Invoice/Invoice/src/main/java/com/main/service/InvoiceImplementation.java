package com.main.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Invoice;
import com.main.repository.InvoiceDoa;

@Service
@Transactional
public class InvoiceImplementation implements InvoiceService {
	@Autowired
	InvoiceDoa repo;

	public List<Invoice> viewAllInvoices() {
		return repo.findAll();
	}

	public void createInvoice(Invoice invoice) {
		repo.save(invoice);
	}

	public Optional<Invoice> viewAInvoice(int id) {
		return repo.findById(id);
	}

}
