package com.quest.service;

import com.quest.domain.Employees;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author Jason Park
 * @since v1.0.0
 */
public interface EmployeesService {

  Optional<Page<Employees>> getEmployees(Pageable pageable);

  void addEmployees(List<Employees> employees);
}
