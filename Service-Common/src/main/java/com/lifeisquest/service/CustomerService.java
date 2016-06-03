package com.lifeisquest.service;

import com.lifeisquest.domain.Customer;
import com.lifeisquest.domain.Product;
import com.lifeisquest.domain.Store;
import com.lifeisquest.repository.CustomerRepository;
import com.lifeisquest.repository.StoreRepository;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
public class CustomerService {
  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomerService.class);
  @Autowired
  CustomerRepository customerRepo;


  public Customer findByEmail(String email){

    List<Customer> customers = customerRepo.findAll();
    for(Customer customer : customers){
      if(customer.getEmail().equals(email)){
        return customer;
      }
    }
    return null;
  }
  @Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
  public boolean save(Customer customer) {
    //if(customerRepo.exists(customer.getEmail())) return false;
    try {
      customerRepo.save(customer);
    }
    catch(Exception e){
      logger.error("Customer Save Fail : "+e.toString());
      throw e;
    }
    return true;

  }
  public List<Customer> findAll(){
    return customerRepo.findAll();
  }

  public Customer findOne(long id) {

    return customerRepo.findOne(id);
  }
}
