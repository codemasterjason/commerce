package com.lifeisquest.domain;

import java.util.Calendar;
import java.util.Date;

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
 * @since : 2016. 5. 17.
 */
@Entity
@Data
@Table(name="customer")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name ="ID")
  private long id;

  @NotNull
  @Column(name ="name_first")
  private String name_first;

  @NotNull
  @Column(name ="name_last")
  private String name_last;

  @NotNull
  @Column(name ="email")
  private String email;

  @NotNull
  @Column(name ="password")
  private String password;

  @NotNull
  @Column(name="created_at")
  private Date createTime;

  @NotNull
  @Column(name="updated_at")
  private Date updateTime;


  public Customer(String name_first, String name_last, String email, String password){
    this.name_first = name_first;
    this.name_last = name_last;
    this.email = email;
    this.password = password;
    this.createTime = Calendar.getInstance().getTime();
    this.updateTime = Calendar.getInstance().getTime();
  }
}
