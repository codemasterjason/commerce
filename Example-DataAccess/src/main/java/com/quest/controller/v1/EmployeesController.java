package com.quest.controller.v1;

import com.quest.annotation.Delete;
import com.quest.annotation.Get;
import com.quest.annotation.Post;
import com.quest.annotation.Put;
import com.quest.domain.Employees;
import com.quest.service.EmployeesService;
import com.quest.util.MessageCode;
import com.quest.util.ResponseFactory;
import com.quest.util.ResponseObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    return responseFactory.get(MessageCode.SUCCESS, employees.get());
  }

  @Post("")
  public ResponseObj addEmployees(@RequestBody List<Employees> employees) {
    // TODO: limit size of list.
    employeesService.addEmployees(employees);
    return responseFactory.get(MessageCode.SUCCESS);
  }

  @Put("")
  public ResponseObj modifyEmployees() {
    return null;
  }

  @Delete("")
  public ResponseObj removeEmployees() {
    return null;
  }
}
