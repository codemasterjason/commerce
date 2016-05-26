package com.lifeisquest.controller.v1;

import com.lifeisquest.annotation.Get;
import com.lifeisquest.domain.Customer;
import com.lifeisquest.domain.Order;
import com.lifeisquest.domain.Product;
import com.lifeisquest.domain.Store;
import com.lifeisquest.service.CustomerService;
import com.lifeisquest.service.OrderService;
import com.lifeisquest.service.ProductService;
import com.lifeisquest.service.StoreService;
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
@RequestMapping("api/v1/payment")
public class PaymentConroller {

  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProductController.class);
  @Autowired
  OrderService orderService;

  @Autowired
  ProductService productService;

  @Autowired
  StoreService storeService;

  @Autowired
  CustomerService customerService;

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public ResponseObj addOrder(@RequestParam(value = "customerId") long customerId,
                              @RequestParam(value = "storeId") long storeId,
                              @RequestParam(value = "quantity") int quantity)
  {
    logger.info("[Addorder]");
    Store store = storeService.findOne(storeId);
    logger.info("storeId = "+storeId);

    Customer customer = customerService.findOne(customerId);
    logger.info("customerId = "+ customerId);
    //Hide and cancel is "Y" because customer buy product
    Order order = new Order(quantity,"N", "N", store, customer);
    orderService.save(order);
    return new ResponseObj(MessageCode.SUCCESS,"ok");
  }
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ResponseObj getOrderlist(){


    return new ResponseObj(MessageCode.SUCCESS,orderService.findAll());
  }
  @RequestMapping(value = "/cancel", method = RequestMethod.GET)
  public ResponseObj cancelOrder(@RequestParam(value = "orderId") long orderId){

    orderService.delete(orderId);
    //or update orderService

    return new ResponseObj(MessageCode.SUCCESS,"order canceled!");
  }
}
