package com.quest.controller.v1;

import com.quest.annotation.Delete;
import com.quest.annotation.Get;
import com.quest.annotation.Post;
import com.quest.annotation.Put;
import com.quest.domain.Employees;
import com.quest.service.EmployeesService;
import com.quest.util.MessageCode;
import com.quest.util.ResponseFactory;
import com.quest.validator.ListParamValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

  @InitBinder
  protected void initBinder(WebDataBinder binder) {
    binder.setValidator(new ListParamValidator());
  }

  @Get("")
  public ResponseEntity getEmployees(Pageable pageable) {
    Optional<Page<Employees>> employees = employeesService.getEmployees(pageable);
    return responseFactory.get(MessageCode.SUCCESS, employees.get());
  }

  @Post("")
  public ResponseEntity addEmployees(@Valid @RequestBody List<Employees> employees) {
    if (employees.stream().anyMatch(p -> p.getEmpNo() != null)) {
      // TODO: Global exception handling.
      return responseFactory.get(MessageCode.FAIL);
    }
    employeesService.addOrModifyEmployees(employees);
    return responseFactory.get(MessageCode.SUCCESS, HttpStatus.CREATED);
  }

  @Put("")
  public ResponseEntity modifyEmployees(@Valid @RequestBody List<Employees> employees) {
    if (employees.stream().anyMatch(p -> p.getEmpNo() == null)) {
      // TODO: Global exception handling.
      return responseFactory.get(MessageCode.FAIL, HttpStatus.NO_CONTENT);
    }
    List<Long> empNoList = employees.stream()
        .map(employee -> new Long(employee.getEmpNo()))
        .collect(Collectors.toList());
    Optional<List<Employees>> employeesAll = employeesService.getEmployeesAll(empNoList);
    if (employeesAll.isPresent() && employeesAll.get().size() != employees.size()) {
      // TODO: Global exception handling.
      return responseFactory.get(MessageCode.FAIL);
    }
    employeesService.addOrModifyEmployees(employees);
    return responseFactory.get(MessageCode.SUCCESS);
  }

  @Delete("/{empNo}")
  public ResponseEntity removeEmployees(@PathVariable Long empNo) {
    employeesService.removeEmployees(empNo);
    return responseFactory.get(MessageCode.SUCCESS);
  }
}
