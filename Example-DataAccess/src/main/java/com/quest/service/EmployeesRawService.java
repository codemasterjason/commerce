package com.quest.service;

import com.quest.domain.Employees;
import com.quest.model.RowBounds;

import java.util.List;
import java.util.Optional;

/**
 * @author Jason Park
 * @since v1.0.0
 */
public interface EmployeesRawService {

  Optional<List<Employees>> getEmployees(RowBounds rowBounds);

  Optional<Employees> getEmployees(Integer empNo);

  void addEmployees(Employees employees);

  Optional<Employees> modifyEmployees(Employees employees);

  void removeEmployees(Employees employees);
}
