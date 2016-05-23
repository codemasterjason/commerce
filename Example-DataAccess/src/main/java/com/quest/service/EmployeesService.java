package com.quest.service;

import com.quest.domain.Employees;
import com.quest.model.RowBounds;

import java.util.List;
import java.util.Optional;

/**
 * @author Jason Park
 * @since v1.0.0
 */
public interface EmployeesService {

  Optional<List<Employees>> getEmployees(RowBounds rowBounds);

  void addEmployees(Employees employees);

  Optional<Employees> modifyEmployees(Employees employees);
}
