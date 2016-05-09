package com.lifeisquest.repository;

import com.lifeisquest.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Steven Jee
 * @since v.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
