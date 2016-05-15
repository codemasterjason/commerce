package com.lifeisquest.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @version : 1.0
 * @author: : patrian
 * @since : 2016. 5. 10.
 */
@Entity
@Table(name="product")
public @Data class Product implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name ="ID")
  private long id;

  @NotNull
  @Column(name ="name")
  private String name;

  @NotNull
  @Column(name="description")
  private String description;

  @NotNull
  @Column(name="price")
  private int price;

  @NotNull
  @Column(name="hide")
  private String hide;

  @NotNull
  @Column(name="created_at")
  private Date createTime;

  @NotNull
  @Column(name="updated_at")
  private Date updateTime;

  @OneToMany(mappedBy = "product")
  private List<Store> stores = new ArrayList<Store>();

  public void addStore(Store store){
    this.stores.add(store);
    if(store.getProduct() != this){
      store.setProduct(this);
    }
  }

}
