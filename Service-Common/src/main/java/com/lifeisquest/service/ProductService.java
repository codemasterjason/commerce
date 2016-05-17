package com.lifeisquest.service;

import com.lifeisquest.domain.Product;
import com.lifeisquest.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @version : 1.0
 * @author: : patrian
 * @since : 2016. 5. 12.
 */
@Service
@Transactional
public class ProductService {

  @Autowired
  ProductRepository productRepo;


  public Product getProduct(Long id) {

    return productRepo.findOne(id);
  }


  public void save(List<Product> products){
    for(Product product : products){
      productRepo.save(product);
    }
  }


  public void save(Product product) {
    productRepo.save(product);

  }




}
