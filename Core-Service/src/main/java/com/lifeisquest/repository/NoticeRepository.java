package com.lifeisquest.repository;

import com.lifeisquest.domain.Notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

  Notice findLastByOrderById();
}
