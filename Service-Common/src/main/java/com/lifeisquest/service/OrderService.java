package com.lifeisquest.service;

import com.lifeisquest.domain.Customer;
import com.lifeisquest.domain.Order;
import com.lifeisquest.domain.Store;
import com.lifeisquest.repository.OrderRepository;
import com.lifeisquest.repository.StoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class OrderService {
  @Autowired
  OrderRepository orderRepo;

  public void save(List<Order> orders){
    for(Order order : orders){
      orderRepo.save(order);
    }
  }


  public void save(Order order) {
    orderRepo.save(order);

  }
  public List<Order> findAll(){
    return orderRepo.findAll();
  }
}
