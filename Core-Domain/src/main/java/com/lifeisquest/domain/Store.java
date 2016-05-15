package com.lifeisquest.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @version : 1.0
 * @author: : patrian
 * @since : 2016. 5. 13.
 */
@Entity
@Table(name="store")
@Data
public class Store {
  /*
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(10) unsigned NOT NULL,
  `quantity` int(10) unsigned NOT NULL,
  `discount` decimal(10,0) unsigned NOT NULL COMMENT '할인가',
  `hide` char(1) NOT NULL DEFAULT 'N',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_store_product1_idx` (`product_id`),
  CONSTRAINT `fk_store_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name ="ID")
  private long id;


  @NotNull
  @Column(name ="quantity")
  private int quantity;

  @NotNull
  @Column(name ="discount")
  private int disCount;

  @NotNull
  @Column(name ="hide")
  private String hide;

  @NotNull
  @Column(name="created_at")
  private Date createTime;

  @NotNull
  @Column(name="updated_at")
  private Date updateTime;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  public void setProduct(Product product){
    this.product = product;

    if(!product.getStores().contains(this)){
      product.getStores().add(this);
    }
  }


}
