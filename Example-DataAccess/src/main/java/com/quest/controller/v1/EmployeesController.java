package com.quest.controller.v1;

import com.quest.annotation.Get;
import com.quest.domain.Employees;
import com.quest.service.EmployeesService;
import com.quest.util.MessageCode;
import com.quest.util.ResponseFactory;
import com.quest.util.ResponseObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@RestController
@RequestMapping("api/v1/employees")
public class EmployeesController {

  @Autowired
  ResponseFactory responseFactory;

  @Autowired
  EmployeesService employeesService;

  @Get("")
  public ResponseObj getEmployees(Pageable pageable) {
    Optional<Page<Employees>> employees = employeesService.getEmployees(pageable);
    if (!employees.isPresent()) {
      return responseFactory.get(MessageCode.DAO_FAIL);
    }
    return responseFactory.get(MessageCode.SUCCESS, employees.get());
  }
}
