package com.quest.service;

import com.quest.domain.Employees;
import com.quest.repository.EmployeesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@Service
public class EmployeesServiceImpl implements EmployeesService {

  @Autowired
  EmployeesRepository employeesRepository;

  @Override
  public Optional<Page<Employees>> getEmployees(Pageable pageable) {
    return Optional.ofNullable(employeesRepository.findAll(pageable));
  }

  @Override
  public void addEmployees(List<Employees> employees) {
    employeesRepository.save(employees);
  }
}
