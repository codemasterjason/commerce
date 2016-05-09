package com.lifeisquest.controller.v1;

import com.lifeisquest.annotation.Get;
import com.lifeisquest.domain.Customer;
import com.lifeisquest.service.CustomerService;
import com.lifeisquest.util.MessageCode;
import com.lifeisquest.util.ResponseObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Steven Jee
 * @since v.
 */
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
  @Autowired
  CustomerService customerService;

  @Get("")
  public ResponseObj getLatestNotice() {
    List<Customer> latestNotice = customerService.getAllCustomer();
    return new ResponseObj(MessageCode.SUCCESS, latestNotice);
  }
}
