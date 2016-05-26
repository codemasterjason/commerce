package com.quest.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author Jason Park
 * @since v
 */
public class SalariesPK implements Serializable {
  private Long empNo;
  private Date fromDate;

  @Column(name = "emp_no", nullable = false)
  @Id
  public Long getEmpNo() {
    return empNo;
  }

  public void setEmpNo(Long empNo) {
    this.empNo = empNo;
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

    SalariesPK that = (SalariesPK) o;

    if (empNo != null ? !empNo.equals(that.empNo) : that.empNo != null) return false;
    if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = empNo != null ? empNo.hashCode() : 0;
    result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
    return result;
  }
}
