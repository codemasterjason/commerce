package com.lifeisquest.controller.v1;

import com.lifeisquest.annotation.Get;
import com.lifeisquest.annotation.Post;
import com.lifeisquest.aspect.GlobalExceptionLoggingHandler;
import com.lifeisquest.domain.Product;
import com.lifeisquest.domain.Store;
import com.lifeisquest.service.CustomerService;
import com.lifeisquest.service.OrderService;
import com.lifeisquest.service.ProductService;
import com.lifeisquest.service.StoreService;
import com.lifeisquest.util.MessageCode;
import com.lifeisquest.util.ResponseObj;
import com.sun.media.jfxmedia.logging.Logger;

import org.slf4j.LoggerFactory;
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


  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProductController.class);

  @Autowired
  private StoreService storeService;
  @Autowired
  private ProductService productService;

  @Autowired
  private CustomerService customerService;

  @Autowired
  private OrderService orderService;


  @Get
  public ResponseObj getProductList(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                    @RequestParam(value = "count", defaultValue = "15") int count){
    logger.info("[getProductList]");
    logger.info("offset = "+ offset);
    logger.info("count = "+ count);
    return new ResponseObj(MessageCode.SUCCESS,storeService.getItemPerCount(offset,count));
  }

  @RequestMapping(value = "{productId}", method = RequestMethod.GET)
  public ResponseObj getDetailProduct(@PathVariable Long productId){
    logger.info("[getDetailProduct]");
    logger.info("product_id = " +productId);
    return new ResponseObj(MessageCode.SUCCESS,storeService.findOneByProductId(productId));
  }

  @Post(value = "/addstore")
  public ResponseObj addStoreItem(@RequestParam(value = "productId", defaultValue = "0") Long productId,
                              @RequestParam(value = "quantity", defaultValue = "0") int quantity,
                              @RequestParam(value = "discount", defaultValue = "0") int discount,
                              @RequestParam(value = "hide", defaultValue = "N") String hide){
    Product item = productService.getProduct(productId);
    Store store = new Store(quantity,discount,hide,item);
    storeService.save(store);
    logger.info("[Addstore]");
    logger.info("productId = "+ productId);
    logger.info("quantity = "+ quantity);
    logger.info("discount = "+ discount);
    logger.info("hide = "+ hide);
    return new ResponseObj(MessageCode.SUCCESS,store);
  }

  @Post(value = "/addProduct")
  public ResponseObj addProduct(@RequestParam(value = "name", defaultValue = "Init") String name,
                                @RequestParam(value = "price", defaultValue = "0") Integer price,
                                @RequestParam(value = "description", defaultValue = "No Description") String description,
                                @RequestParam(value = "hide", defaultValue = "N") String hide){
    Product product = new Product(name,description,price,hide);

    logger.info("name = "+ name);
    logger.info("price = "+ price);
    logger.info("description = "+ description);
    logger.info("hide = "+ hide);

    return new ResponseObj(MessageCode.SUCCESS,product);
  }

}
