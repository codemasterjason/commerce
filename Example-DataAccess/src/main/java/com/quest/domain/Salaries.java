package com.quest.domain;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author Jason Park
 * @since v
 */
@Entity
@IdClass(SalariesPK.class)
public class Salaries {
  private Long empNo;
  private Integer salary;
  private Date fromDate;
  private Date toDate;

  @Id
  @Column(name = "emp_no", nullable = false)
  public Long getEmpNo() {
    return empNo;
  }

  public void setEmpNo(Long empNo) {
    this.empNo = empNo;
  }

  @Basic
  @Column(name = "salary", nullable = false)
  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }

  @Id
  @Column(name = "from_date", nullable = false)
  public Date getFromDate() {
    return fromDate;
  }

  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }

  @Basic
  @Column(name = "to_date", nullable = false)
  public Date getToDate() {
    return toDate;
  }

  public void setToDate(Date toDate) {
    this.toDate = toDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Salaries salaries = (Salaries) o;

    if (empNo != null ? !empNo.equals(salaries.empNo) : salaries.empNo != null) return false;
    if (salary != null ? !salary.equals(salaries.salary) : salaries.salary != null) return false;
    if (fromDate != null ? !fromDate.equals(salaries.fromDate) : salaries.fromDate != null)
      return false;
    if (toDate != null ? !toDate.equals(salaries.toDate) : salaries.toDate != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = empNo != null ? empNo.hashCode() : 0;
    result = 31 * result + (salary != null ? salary.hashCode() : 0);
    result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
    result = 31 * result + (toDate != null ? toDate.hashCode() : 0);
    return result;
  }
}
