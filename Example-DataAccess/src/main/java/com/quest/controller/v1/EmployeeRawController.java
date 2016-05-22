package com.quest.controller.v1;

import com.google.common.collect.Lists;

import com.lifeisquest.annotation.Get;
import com.lifeisquest.util.MessageCode;
import com.lifeisquest.util.ResponseObj;
import com.quest.model.RowBounds;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.validation.Valid;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@RestController
@RequestMapping("v1/employee")
public class EmployeeRawController {

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
  @Get("")
  public ResponseObj getEmployee(@Valid RowBounds rowBounds) {
    EntityManager em = this.emf.createEntityManager();
    List<Object> resultList = Lists.newArrayList();
    try {
      Query query = em.createQuery("from Employees as E")
          .setFirstResult(rowBounds.getOffset() * rowBounds.getRowCount())
          .setMaxResults(rowBounds.getRowCount());
      resultList = query.getResultList();
    } finally {
      if (em != null) {
        em.close();
      }
    }

    System.out.println(rowBounds);

    return new ResponseObj(MessageCode.SUCCESS, resultList);
  }
}
