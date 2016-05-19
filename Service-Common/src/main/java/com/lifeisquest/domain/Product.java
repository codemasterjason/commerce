package com.lifeisquest.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  @JsonBackReference
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

  public Product(){

  }
  public Product(String name,Object description, int price, String hide){
    this.name = name;
    this.description = description.toString();
    this.price = price;
    this.hide = hide;
    this.createTime = Calendar.getInstance().getTime();
    this.updateTime = Calendar.getInstance().getTime();
  }

}
