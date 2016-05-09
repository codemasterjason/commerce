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
public class Store {
  @Id
  @GeneratedValue
  private Long id;
  private Long product_id;
  private Integer quantity;
  private Integer discount;
  private Character hide;
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyyMMdd", timezone="Asia/Seoul")
  private DateTime created_at;
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyyMMdd", timezone="Asia/Seoul")
  private DateTime updated_at;
}
