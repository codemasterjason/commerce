package com.lifeisquest.service;

import com.lifeisquest.domain.Store;
import com.lifeisquest.repository.ProductRepository;
import com.lifeisquest.repository.StoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version : 1.0
 * @author: : patrian
 * @since : 2016. 5. 13.
 */

@Service
public class StoreServce {
  @Autowired
  StoreRepository storeRepo;

  public List<Store> findAll(){
    return storeRepo.findAll();
  }
}
