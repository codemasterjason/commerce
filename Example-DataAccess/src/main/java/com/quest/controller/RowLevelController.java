package com.quest.controller;

import com.google.common.collect.Lists;

import com.lifeisquest.annotation.Get;
import com.lifeisquest.util.MessageCode;
import com.lifeisquest.util.ResponseObj;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@RestController
@RequestMapping("row_level/v1")
public class RowLevelController {

  private EntityManagerFactory emf;

  @PersistenceUnit
  public void setEntityManagerFactory(EntityManagerFactory emf) {
    this.emf = emf;
  }

  /**
   * Get employee rows as sample.
   *
   * @return ResponseObj
   */
  @Get("/employee")
  public ResponseObj getEmployee() {
    EntityManager em = this.emf.createEntityManager();
    List<Object> resultList = Lists.newArrayList();
    try {
      Query query = em.createQuery("from Employees as E").setMaxResults(2);
      resultList = query.getResultList();
    } finally {
      if (em != null) {
        em.close();
      }
    }

    return new ResponseObj(MessageCode.SUCCESS, resultList);
  }
}
