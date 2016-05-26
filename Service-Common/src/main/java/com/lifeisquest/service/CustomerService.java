package com.lifeisquest.service;

import com.lifeisquest.domain.Customer;
import com.lifeisquest.domain.Product;
import com.lifeisquest.domain.Store;
import com.lifeisquest.repository.CustomerRepository;
import com.lifeisquest.repository.StoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version : 1.0
 * @author: : patrian
 * @since : 2016. 5. 13.
 */

@Service
@Transactional
public class CustomerService {
  @Autowired
  CustomerRepository customerRepo;

  public void save(List<Customer> customers){
    for(Customer customer : customers){
      customerRepo.save(customer);
    }
  }
  public Customer findByEmail(String email){

    List<Customer> customers = customerRepo.findAll();
    for(Customer customer : customers){
      if(customer.getEmail().equals(email)){
        return customer;
      }
    }
    return null;
  }

  public void save(Customer customer) {
    customerRepo.save(customer);

  }
  public List<Customer> findAll(){
    return customerRepo.findAll();
  }

  public Customer findOne(long id) {

    return customerRepo.findOne(id);
  }
}
