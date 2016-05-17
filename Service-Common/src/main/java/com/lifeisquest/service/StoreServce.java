package com.lifeisquest.service;

import com.lifeisquest.domain.Store;
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
public class StoreServce {
  @Autowired
  StoreRepository storeRepo;

  /*
   find one product each productId
   */
  public List<Map> findOne(long productId){

    List<Store> storeList = storeRepo.findAll();
    List<Map> dataList = new ArrayList<Map>();

    for(Store item : storeList) {
      if(item.getProduct().getId()==productId) {
        Map data = new HashMap<String, Object>();
        data.put("id", item.getProduct().getId());
        data.put("name", item.getProduct().getName());
        data.put("description", item.getProduct().getDescription());
        data.put("price", item.getProduct().getPrice());
        data.put("discount", item.getDisCount());
        dataList.add(data);
        break;
      }
    }

    return dataList;
  }

  /*

   */
  public List<Map> getItemPerCount(Integer offset, Integer count) {
    List<Store> storeList = storeRepo.findAll();
    //Page pageOfProducts = storeRepo.findAll(new PageRequest(page, size));
    List<Map> dataList = new ArrayList<Map>();
    int listSize = storeList.size();
    int bringCount=offset+count;
    for(int i=offset;i<bringCount;i++){
      if(listSize<=i) break;
      Store item =storeList.get(i);
      Map data = new HashMap<String, Object>();
      data.put("name",item.getProduct().getName());
      data.put("description",item.getProduct().getDescription());
      data.put("price",item.getProduct().getPrice());
      data.put("discount",item.getDisCount());
      dataList.add(data);
    }
    return dataList;
  }
}
