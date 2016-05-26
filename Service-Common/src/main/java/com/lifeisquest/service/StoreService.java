package com.lifeisquest.service;



import com.lifeisquest.domain.QStore;
import com.lifeisquest.domain.Store;
import com.lifeisquest.repository.StoreRepository;
import com.mysema.query.SearchResults;
import com.mysema.query.jpa.impl.JPAQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @version : 1.0
 * @author: : patrian
 * @since : 2016. 5. 13.
 */

@Service
@Transactional
public class StoreService extends QueryDslRepositorySupport {
  @Autowired
  private StoreRepository storeRepo;

  @PersistenceContext
  private EntityManager entityManager;

  /*
   find one product each productId
   */
  public Map findOneByProductId(long productId) {
    Map data = new HashMap<String, Object>();
    QStore astore = QStore.store;
    JPAQuery query = new JPAQuery(entityManager);


    SearchResults<Store> storeSearchResults = query.from(astore).where(astore.product.id.eq(productId)).listResults(astore);

    for(Store item : storeSearchResults.getResults()) {
        data.put("id", item.getProduct().getId());
        data.put("name", item.getProduct().getName());
        data.put("description", item.getProduct().getDescription());
        data.put("price", item.getProduct().getPrice());
        data.put("discount", item.getDisCount());
        return data;
    }
    return data;
  }
  public StoreService() {
    super(Store.class);
  }

  /*
   save 1 item
   */
  public void save(List<Store> stores){
    for(Store item : stores){
      storeRepo.save(item);
    }
  }

  /*
   save Store list
   */
  public void save(Store store){
    storeRepo.save(store);
  }

  public Store findOne(long storeId) {

    return storeRepo.findOne(storeId);
  }




  /*
    return get datalist(Count per)
   */
  public List<Map> getItemPerCount(Integer offset, Integer count) {
    List<Store> storeList = storeRepo.findAll();
    //Page pageOfProducts = storeRepo.findAll(new PageRequest(page, size));
    List<Map> dataList = new ArrayList<Map>();
    int listSize = storeList.size();
    int bringCount=offset+count;
    for(int i=offset;i<bringCount;i++){
      if(listSize<=i) break;
      Store item =storeList.get(i);
      Map data = new HashMap<String, Object>();
      data.put("name",item.getProduct().getName());
      data.put("description",item.getProduct().getDescription());
      data.put("price",item.getProduct().getPrice());
      data.put("discount",item.getDisCount());
      dataList.add(data);
    }
    return dataList;
  }
}
