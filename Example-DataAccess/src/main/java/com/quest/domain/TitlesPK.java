package com.quest.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author Jason Park
 * @since v1.0.0
 */
public class TitlesPK implements Serializable {
  private int empNo;
  private String title;
  private Date fromDate;

  @Column(name = "emp_no", nullable = false)
  @Id
  public int getEmpNo() {
    return empNo;
  }

  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  @Column(name = "title", nullable = false, length = 50)
  @Id
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Column(name = "from_date", nullable = false)
  @Id
  public Date getFromDate() {
    return fromDate;
  }

  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TitlesPK titlesPK = (TitlesPK) o;

    if (empNo != titlesPK.empNo) return false;
    if (title != null ? !title.equals(titlesPK.title) : titlesPK.title != null) return false;
    if (fromDate != null ? !fromDate.equals(titlesPK.fromDate) : titlesPK.fromDate != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = empNo;
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
    return result;
  }
}
