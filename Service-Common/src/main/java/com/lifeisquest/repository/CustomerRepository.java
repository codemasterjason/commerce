package com.lifeisquest.repository;

import com.lifeisquest.domain.Customer;
import com.lifeisquest.domain.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @version : 1.0
 * @author: : patrian
 * @since : 2016. 5. 13.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
