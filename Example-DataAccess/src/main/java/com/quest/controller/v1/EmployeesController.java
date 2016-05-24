package com.quest.controller.v1;

import com.quest.annotation.Get;
import com.quest.model.RowBounds;
import com.quest.util.ResponseObj;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@RestController
@RequestMapping("api/v1/employees")
public class EmployeesController {

  @Get("")
  public ResponseObj getEmployees(@Valid RowBounds rowBounds) {
    return null;
  }
}
