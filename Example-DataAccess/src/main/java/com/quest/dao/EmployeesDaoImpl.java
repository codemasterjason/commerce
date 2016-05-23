package com.quest.dao;

import com.quest.domain.Employees;
import com.quest.model.RowBounds;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@Repository
public class EmployeesDaoImpl implements EmployeesDao {

  @PersistenceContext
  private EntityManager em;

  @Override
  public Optional<List<Employees>> findEmployees(RowBounds rowBounds) {
    Query query = em.createQuery("from Employees as E")
        .setFirstResult(rowBounds.getOffset() * rowBounds.getRowCount())
        .setMaxResults(rowBounds.getRowCount());
    Optional<List<Employees>> employees = Optional.of(query.getResultList());
    return employees;
  }

  @Override
  public Optional<Employees> findEmployeesByEmpNo(Integer empNo) {
    Optional<Employees> employees = Optional.ofNullable(em.find(Employees.class, empNo));
    return employees;
  }

  @Override
  public void save(Employees employees) {
    em.persist(employees);
  }

  @Override
  public Optional<Employees> merge(Employees employees) {
    return Optional.of(em.merge(employees));
  }

  @Override
  public void delete(Employees employees) {
    em.remove(employees);
  }
}
