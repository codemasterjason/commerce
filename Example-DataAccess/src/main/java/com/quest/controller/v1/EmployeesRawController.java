package com.quest.controller.v1;

import com.quest.annotation.Delete;
import com.quest.annotation.Get;
import com.quest.annotation.Post;
import com.quest.annotation.Put;
import com.quest.domain.Employees;
import com.quest.model.RowBounds;
import com.quest.service.EmployeesRawService;
import com.quest.util.MessageCode;
import com.quest.util.ResponseFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("api/v1/employees/raw")
public class EmployeesRawController {

  @Autowired
  ResponseFactory responseFactory;

  @Autowired
  EmployeesRawService employeesRawService;

  /**
   * Get employee rows as sample.
   *
   * @return ResponseObj
   */
  @Get("")
  public ResponseEntity getEmployees(@Valid RowBounds rowBounds) {
    Optional<List<Employees>> employees = employeesRawService.getEmployees(rowBounds);
    if (!employees.isPresent()) {
      return responseFactory.get(MessageCode.DAO_FAIL);
    }
    return responseFactory.get(MessageCode.SUCCESS, employees.get());
  }

  @Get("/{empNo}")
  public ResponseEntity getEmployees(@PathVariable Integer empNo) {
    Optional<Employees> employees = employeesRawService.getEmployees(empNo);
    if (!employees.isPresent()) {
      return responseFactory.get(MessageCode.DAO_FAIL);
    }
    return responseFactory.get(MessageCode.SUCCESS, employees.get());
  }

  @Post("")
  public ResponseEntity addEmployees(@Valid Employees employees) {
    employeesRawService.addEmployees(employees);
    return responseFactory.get(MessageCode.SUCCESS);
  }

  @Put("")
  public ResponseEntity modifyEmployees(@Valid Employees employees) {
    Optional<Employees> employeesReturn = employeesRawService.modifyEmployees(employees);
    if (!employeesReturn.isPresent()) {
      return responseFactory.get(MessageCode.DAO_FAIL);
    }
    return responseFactory.get(MessageCode.SUCCESS, employeesReturn.get());
  }

  @Delete("/{empNo}")
  public ResponseEntity deleteEmployees(@PathVariable Integer empNo) {
    Optional<Employees> employees = employeesRawService.getEmployees(empNo);
    if (!employees.isPresent()) {
      return responseFactory.get(MessageCode.DAO_FAIL);
    }
    employeesRawService.removeEmployees(employees.get());
    return responseFactory.get(MessageCode.SUCCESS);
  }
}
