package com.bkcoding.taxi24.services.impl;

import com.bkcoding.taxi24.domain.Invoice;
import com.bkcoding.taxi24.repositories.InvoiceRepository;
import com.bkcoding.taxi24.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
  @Autowired private InvoiceRepository repository;

  @Override
  public Invoice create(Invoice invoice) {
    return repository.save(invoice);
  }

  @Override
  public List<Invoice> invoices() {
    return repository.findAll();
  }
}
