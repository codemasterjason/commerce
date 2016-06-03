package com.lifeisquest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @version : 1.0
 * @author: : patrian
 * @since : 2016. 5. 17.
 */
@Entity
@Data
@Table(name = "[order]")
public class Order implements Serializable {
  @Transient
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name ="id")
  private long id;
  /*
  @NotNull
  @Column(name="store_id")
  private long store_id;

  @NotNull
  @Column(name="customer_id")
  private long customer_id;*/

  @NotNull
  @Column(name ="quantity")
  private int quantity;

  @NotNull
  @Column(name ="cancel")
  private String cancel;

  @NotNull
  @Column(name ="hide")
  private String hide;

  @NotNull
  @Column(name="created_at")
  private Date createTime;

  @NotNull
  @Column(name="updated_at")
  private Date updateTime;


  @ManyToOne(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
  @JoinColumn(name = "store_id")
  private Store store;

  @ManyToOne(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
  @JoinColumn(name = "customer_id")
  private Customer customer;
  public Order(){

  }

  public Order(int quantity,String cancel, String hide, Store store, Customer customer){
    this.quantity = quantity;
    this.cancel = cancel;
    this.hide = hide;
    this.store = store;
    this.customer = customer;
    this.createTime = Calendar.getInstance().getTime();
    this.updateTime = Calendar.getInstance().getTime();
  }
  /*public Order(int quantity,String cancel, String hide, long store_id, long customer_id){
    this.quantity = quantity;
    this.cancel = cancel;
    this.hide = hide;
    this.store_id = store_id;
    this.customer_id = customer_id;
    this.createTime = Calendar.getInstance().getTime();
    this.updateTime = Calendar.getInstance().getTime();
  }*/

}
