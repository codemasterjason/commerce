package com.lifeisquest.repository;

import com.lifeisquest.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @version : 1.0
 * @author: : patrian
 * @since : 2016. 5. 12.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
