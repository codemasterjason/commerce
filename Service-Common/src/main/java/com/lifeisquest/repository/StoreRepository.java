package com.lifeisquest.repository;

import com.lifeisquest.domain.Store;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @version : 1.0
 * @author: : patrian
 * @since : 2016. 5. 13.
 */
public interface StoreRepository extends JpaRepository<Store, Long> {
}
