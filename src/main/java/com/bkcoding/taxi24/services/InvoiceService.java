package com.bkcoding.taxi24.services;

import com.bkcoding.taxi24.domain.Invoice;

import java.util.List;

public interface InvoiceService {
  Invoice create(Invoice invoice);

  List<Invoice> invoices();
}
