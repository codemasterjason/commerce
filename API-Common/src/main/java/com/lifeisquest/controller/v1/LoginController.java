package com.lifeisquest.controller.v1;

import com.lifeisquest.annotation.Get;
import com.lifeisquest.annotation.Post;
import com.lifeisquest.domain.Customer;
import com.lifeisquest.service.CustomerService;
import com.lifeisquest.service.OrderService;
import com.lifeisquest.util.MessageCode;
import com.lifeisquest.util.ResponseObj;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version : 1.0
 * @author: : patrian
 * @since : 2016. 5. 23.
 */

@RestController
@RequestMapping("api/v1/user")
public class LoginController {

  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProductController.class);

  @Autowired
  CustomerService customerService;

  @Autowired
  OrderService orderService;


  @Get(value = "/login")
  public ResponseObj checkLoginInfo(@RequestParam(value = "email") String email,
                                     @RequestParam(value = "password") String password) {
    Customer customer = customerService.findByEmail(email);
    if(customer == null) return new ResponseObj(MessageCode.FAIL,"It does not registered email.");

    if(customer.getPassword().equals(password)){
      return new ResponseObj(MessageCode.SUCCESS, customer);
    }
    else{
      return new ResponseObj(MessageCode.FAIL,"Please insert correct password.");
    }
  }


  @Post(value = "/signup")
  public ResponseObj addUser(@RequestParam(value = "nameFirst", defaultValue = "0") String nameFirset,
                             @RequestParam(value = "nameLast", defaultValue = "0") String nameLast,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "password") String password) {
    Customer customer = new Customer(nameFirset,nameLast,email,password);
    customerService.save(customer);

    return new ResponseObj(MessageCode.SUCCESS,customer);


  }

  @Get(value = "/list")
  public ResponseObj userList() {

    return new ResponseObj(MessageCode.SUCCESS,customerService.findAll());
  }

  @Get(value = "/profile")
  public ResponseObj getProfileInfo(@RequestParam(value = "email") String email) {

    return new ResponseObj(MessageCode.SUCCESS,orderService.findOrderedItemByEmail(email));
  }
}
