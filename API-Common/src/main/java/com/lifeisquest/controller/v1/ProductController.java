package com.lifeisquest.controller.v1;

import com.lifeisquest.annotation.Get;
import com.lifeisquest.service.StoreServce;
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
  private StoreServce storeService;

  @Get
  public ResponseObj getProductList(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                    @RequestParam(value = "count", defaultValue = "15") Integer count){

    return new ResponseObj(MessageCode.SUCCESS,storeService.getItemPerCount(offset,count));
  }

  @RequestMapping(value = "{productId}", method = RequestMethod.GET)
  public ResponseObj getDetailProduct(@PathVariable Long productId){
    return new ResponseObj(MessageCode.SUCCESS,storeService.findOne(productId));
  }
}
