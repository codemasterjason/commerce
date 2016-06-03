package com.lifeisquest.service;

import com.lifeisquest.domain.Customer;
import com.lifeisquest.domain.Order;
import com.lifeisquest.domain.QOrder;
import com.lifeisquest.domain.QStore;
import com.lifeisquest.domain.Store;
import com.lifeisquest.repository.OrderRepository;
import com.lifeisquest.repository.StoreRepository;
import com.mysema.query.SearchResults;
import com.mysema.query.jpa.impl.JPAQuery;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @version : 1.0
 * @author: : patrian
 * @since : 2016. 5. 13.
 */

@Service
public class OrderService {
  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomerService.class);
  @Autowired
  OrderRepository orderRepo;

  @PersistenceContext
  private EntityManager entityManager;

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
    QOrder aorder = QOrder.order;
    JPAQuery query = new JPAQuery(entityManager);


    //SearchResults<Order> orderSearchResults = query.from(aorder).where(aorder.customer_id.eq(productId)).listResults(astore);

   /* for(Store item : storeSearchResults.getResults()) {
      data.put("id", item.getProduct().getId());
      data.put("name", item.getProduct().getName());
      data.put("description", item.getProduct().getDescription());
      data.put("price", item.getProduct().getPrice());
      data.put("discount", item.getDisCount());
      return data;
    }*/
    List<Order> orders = orderRepo.findAll();
    List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
    for(Order order : orders){
      if(order.getCustomer().getEmail().equals(email)){
        Map<String,Object> dataMap = new HashMap<String,Object>();
        dataMap.put("id", order.getCustomer().getId());
        dataMap.put("name", order.getStore().getId());
        dataMap.put("description", order.getStore().getProduct().getDescription());
        dataMap.put("price", order.getStore().getProduct().getPrice());
        dataMap.put("discount", order.getStore().getDisCount());
        dataMap.put("orderDate",order.getCreateTime());
        dataList.add(dataMap);
      }
    }
    logger.info(dataList.toString());
    return dataList;

  }

  public Order findOne(long id) {

    return orderRepo.findOne(id);
  }
  @Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
  public void delete(long id){
    try {
      orderRepo.delete(id);
    }
    catch(Exception e){
      logger.error("order delete Fail : "+e.toString());
      throw e;
    }
    orderRepo.delete(id);
  }



}
