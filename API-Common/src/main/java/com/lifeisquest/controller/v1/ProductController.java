package com.lifeisquest.controller.v1;

import com.lifeisquest.annotation.Get;
import com.lifeisquest.domain.Product;
import com.lifeisquest.domain.Store;
import com.lifeisquest.service.CustomerService;
import com.lifeisquest.service.OrderService;
import com.lifeisquest.service.ProductService;
import com.lifeisquest.service.StoreService;
import com.lifeisquest.util.MessageCode;
import com.lifeisquest.util.ResponseObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version : 1.0
 * @author: : patrian
 * @since : 2016. 5. 10.
 */
@RestController
@RequestMapping("api/v1/product")
public class ProductController {

  @Autowired
  private StoreService storeService;
  @Autowired
  private ProductService productService;

  @Autowired
  private CustomerService customerService;

  @Autowired
  private OrderService orderService;


  @Get
  public ResponseObj getProductList(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                    @RequestParam(value = "count", defaultValue = "15") Integer count){

    return new ResponseObj(MessageCode.SUCCESS,storeService.getItemPerCount(offset,count));
  }

  @RequestMapping(value = "{productId}", method = RequestMethod.GET)
  public ResponseObj getDetailProduct(@PathVariable Long productId){
    return new ResponseObj(MessageCode.SUCCESS,storeService.findOne(productId));
  }
  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public ResponseObj addProduct(@RequestParam(value = "name", defaultValue = "Init") String name,
                                @RequestParam(value = "price", defaultValue = "0") Integer price,
                                @RequestParam(value = "description", defaultValue = "No Description") String description,
                                @RequestParam(value = "hide", defaultValue = "N") String hide){
    Product product = new Product(name,description,price,hide);
    return new ResponseObj(MessageCode.SUCCESS,product);
  }
  @RequestMapping(value = "/addstore", method = RequestMethod.GET)
  public ResponseObj addStore(@RequestParam(value = "productId", defaultValue = "0") Long productId,
                              @RequestParam(value = "quantity", defaultValue = "0") Integer quantity,
                              @RequestParam(value = "discount", defaultValue = "0") Integer discount,
                              @RequestParam(value = "hide", defaultValue = "N") String hide){
    Product item = productService.getProduct(productId);
    Store store = new Store(quantity,discount,hide,item);
    storeService.save(store);
    return new ResponseObj(MessageCode.SUCCESS,store);
  }
  @RequestMapping(value = "/customerlist", method = RequestMethod.GET)
  public ResponseObj getCustomerList(){
    return new ResponseObj(MessageCode.SUCCESS,customerService.findAll());
  }
  @RequestMapping(value = "/orderlist", method = RequestMethod.GET)
  public ResponseObj getOrderList(){
    return new ResponseObj(MessageCode.SUCCESS,orderService.findAll());
  }
}
