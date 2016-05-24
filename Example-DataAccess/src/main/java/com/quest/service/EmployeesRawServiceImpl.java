package com.quest.service;

import com.quest.dao.EmployeesDao;
import com.quest.domain.Employees;
import com.quest.model.RowBounds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@Service
@Transactional
public class EmployeesRawServiceImpl implements EmployeesRawService {

  @Autowired
  EmployeesDao employeesDao;

  @Override
  public Optional<List<Employees>> getEmployees(RowBounds rowBounds) {
    return employeesDao.findEmployees(rowBounds);
  }

  @Override
  public Optional<Employees> getEmployees(Integer empNo) {
    return employeesDao.findEmployeesByEmpNo(empNo);
  }

  @Override
  public void addEmployees(Employees employees) {
    employeesDao.save(employees);
  }

  @Override
  public Optional<Employees> modifyEmployees(Employees employees) {
    return employeesDao.merge(employees);
  }

  @Override
  public void removeEmployees(Employees employees) {
    employeesDao.delete(employees);
  }
}
