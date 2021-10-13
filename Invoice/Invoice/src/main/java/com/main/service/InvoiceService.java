package com.main.service;

import java.util.List;
import java.util.Optional;

import com.main.model.Invoice;

public interface InvoiceService {

	List<Invoice> viewAllInvoices();

	void createInvoice(Invoice order);

	Optional<Invoice> viewAInvoice(int id);
}
