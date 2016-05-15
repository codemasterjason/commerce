package com.lifeisquest.controller.v1;

import com.lifeisquest.annotation.Get;
import com.lifeisquest.domain.Product;
import com.lifeisquest.domain.Store;
import com.lifeisquest.service.ProductService;
import com.lifeisquest.service.StoreServce;
import com.lifeisquest.util.MessageCode;
import com.lifeisquest.util.ResponseObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version : 1.0
 * @author: : patrian
 * @since : 2016. 5. 10.
 */
@RestController
@RequestMapping("api/v1/product")
public class ProductController {
  private final String productId = "product.id";
  private final String productName = "product.name";
  private final String productDescription = "product.description";
  private final String productPrice = "product.price";
  private final String productDiscount = "product.discount";

  @Autowired
  private ProductService productService;


  @Autowired
  private StoreServce storeService;

  @Get
  public ResponseObj getProductList(@RequestParam(value = "offset", required = true) Integer offset,
                                    @RequestParam(value = "count", required = true) Integer count,
                                    HttpServletRequest request, HttpServletResponse response){
    ArrayList<Map> dataSetList = new ArrayList<Map>();
    Page<Product> productList = productService.getAllProductPerPage(offset,count);
    for(Product item : productList){
      Map data = new HashMap<String,Object>();
      data.put(productId,item.getId());
      data.put(productName,item.getName());
      data.put(productPrice,item.getPrice());
      data.put(productDiscount,item.getStores().get(0).getDisCount());
      dataSetList.add(data);
    }
    return new ResponseObj(MessageCode.SUCCESS,dataSetList);
  }

  @RequestMapping(value = "{productId}", method = RequestMethod.GET)
  public ResponseObj getDetailProduct(@PathVariable Long productId){
    List<Store> storeList = storeService.findAll();
    Product productItem = null;
    Store storeItem = null;
    for(Store item : storeList){
      if(item.getProduct().getId() == productId){
        productItem = item.getProduct();
        storeItem = item;
      }
    }


    Map data = new HashMap<String,Object>();
    if(productItem == null || storeItem == null)
      return new ResponseObj(MessageCode.FAIL);

    data.put(productName,productItem.getName());
    data.put(productDescription,productItem.getDescription());
    data.put(productPrice,productItem.getPrice());
    data.put(productDiscount,storeItem.getDisCount());
    //data.put(productDiscount,item.get);
    return new ResponseObj(MessageCode.SUCCESS,data);
  }
}
