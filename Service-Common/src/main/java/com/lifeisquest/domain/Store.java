package com.lifeisquest.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class Store implements Serializable {
  private static final long serialVersionUID = 1L;
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
  // default : @Temporal(TemporalType.TIMESTAMP)
  @Column(name="created_at")
  private Date createTime;

  @NotNull
  @Column(name="updated_at")
  private Date updateTime;

  @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;

  public Store(){

  }
  public Store(int quantity,int disCount, String hide, Product product){
    this.quantity = quantity;
    this.disCount = disCount;
    this.hide = hide;
    this.product = product;
    this.createTime = Calendar.getInstance().getTime();
    this.updateTime = Calendar.getInstance().getTime();
  }

}
