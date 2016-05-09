package com.lifeisquest.service;

import com.lifeisquest.domain.Customer;
import com.lifeisquest.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Steven Jee
 * @since v.
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
  @Autowired
  CustomerRepository customerRepository;

  @Override
  public List<Customer> getAllCustomer(){
    return customerRepository.findAll();
  }
}
