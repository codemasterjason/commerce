package com.lifeisquest.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

/**
 * @author Steven Jee
 * @since v.
 */
@Entity
@Data
@ToString
public class Customer {
  @Id
  @GeneratedValue
  private Long id;
  private String name_first;
  private String name_last;
  private String email;
  private String password;
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyyMMdd", timezone="Asia/Seoul")
  private DateTime created_at;
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyyMMdd", timezone="Asia/Seoul")
  private DateTime updated_at;
}
