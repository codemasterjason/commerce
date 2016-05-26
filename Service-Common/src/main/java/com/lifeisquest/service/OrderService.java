package com.lifeisquest.service;

import com.lifeisquest.domain.Customer;
import com.lifeisquest.domain.Order;
import com.lifeisquest.domain.Store;
import com.lifeisquest.repository.OrderRepository;
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

  public List<Map<String,Object>> findOrderedItemByEmail(String email){

    List<Order> orders = orderRepo.findAll();
    List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
    for(Order order : orders){
      if(order.getCustomer().getEmail().equals(email)){
        Map<String,Object> dataMap = new HashMap<String,Object>();
        dataMap.put("id", order.getStore().getProduct().getId());
        dataMap.put("name", order.getStore().getProduct().getName());
        dataMap.put("description", order.getStore().getProduct().getDescription());
        dataMap.put("price", order.getStore().getProduct().getPrice());
        dataMap.put("discount", order.getStore().getDisCount());
        dataMap.put("orderDate",order.getCreateTime());
        dataList.add(dataMap);
      }
    }

    return dataList;

  }

  public Order findOne(long id) {

    return orderRepo.findOne(id);
  }
  public void delete(long id){
    orderRepo.delete(id);
  }


}
