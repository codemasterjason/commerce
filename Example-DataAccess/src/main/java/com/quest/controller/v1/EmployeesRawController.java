package com.quest.controller.v1;

import com.google.common.collect.Lists;

import com.quest.annotation.Get;
import com.quest.domain.DeptEmp;
import com.quest.domain.Employees;
import com.quest.model.RowBounds;
import com.quest.service.EmployeesService;
import com.quest.util.MessageCode;
import com.quest.util.ResponseFactory;
import com.quest.util.ResponseObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
@RequestMapping("v1/employees")
public class EmployeesRawController {

  @Autowired
  ResponseFactory responseFactory;

  @Autowired
  EmployeesService employeesService;

  /**
   * Get employee rows as sample.
   *
   * @return ResponseObj
   */
  @Get("")
  public ResponseObj getEmployees(@Valid RowBounds rowBounds) {
    Optional<List<Employees>> employees = employeesService.getEmployees(rowBounds);
    if (!employees.isPresent()) {
      return responseFactory.get(MessageCode.FAIL);
    }
    return responseFactory.get(MessageCode.SUCCESS, employees.get());
  }
}
