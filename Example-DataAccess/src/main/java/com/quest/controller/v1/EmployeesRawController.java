package com.quest.controller.v1;

import com.quest.annotation.Get;
import com.quest.annotation.Post;
import com.quest.annotation.Put;
import com.quest.domain.Employees;
import com.quest.model.RowBounds;
import com.quest.service.EmployeesService;
import com.quest.util.MessageCode;
import com.quest.util.ResponseFactory;
import com.quest.util.ResponseObj;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@RestController
@RequestMapping("api/v1/employees")
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
      return responseFactory.get(MessageCode.DAO_FAIL);
    }
    return responseFactory.get(MessageCode.SUCCESS, employees.get());
  }

  @Post("")
  public ResponseObj addEmployees(@Valid Employees employees) {
    employeesService.addEmployees(employees);
    return responseFactory.get(MessageCode.SUCCESS);
  }

  @Put("")
  public ResponseObj modifyEmployees(@Valid Employees employees) {
    Optional<Employees> employeesReturn = employeesService.modifyEmployees(employees);
    if (!employeesReturn.isPresent()) {
      return responseFactory.get(MessageCode.DAO_FAIL);
    }
    return responseFactory.get(MessageCode.SUCCESS, employeesReturn.get());
  }


}
