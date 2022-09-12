package org.ait.project.customer.modules.customer.service.delegate;

import java.util.List;
import org.ait.project.customer.modules.customer.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerDelegate {

  List<Customer> getAllCustomers();

  Page<Customer> getAllCustomersWithPage(Pageable page);

  Customer getCustomerById(Long id);

  List<Customer> saveAll(List<Customer> customers);

  Customer save(Customer customer);

  void deleteById(Long id);

}
