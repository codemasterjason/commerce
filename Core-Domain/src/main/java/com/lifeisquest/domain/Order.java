package com.lifeisquest.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
public class Order {
  @Id
  @GeneratedValue
  private Long id;
  private Long customer_id;
  private Long store_id;
  private Character cancel;
  private Character hide;
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyyMMdd", timezone="Asia/Seoul")
  private DateTime created_at;
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyyMMdd", timezone="Asia/Seoul")
  private DateTime updated_at;
}
