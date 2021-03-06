package com.quest.domain;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Jason Park
 * @since v
 */
@Entity
@Table(name = "dept_manager", schema = "employees", catalog = "")
@IdClass(DeptManagerPK.class)
public class DeptManager {
  private String deptNo;
  private Long empNo;
  private Date fromDate;
  private Date toDate;
  private Departments departmentsByDeptNo;

  @Id
  @Column(name = "dept_no", nullable = false, length = 4)
  public String getDeptNo() {
    return deptNo;
  }

  public void setDeptNo(String deptNo) {
    this.deptNo = deptNo;
  }

  @Id
  @Column(name = "emp_no", nullable = false)
  public Long getEmpNo() {
    return empNo;
  }

  public void setEmpNo(Long empNo) {
    this.empNo = empNo;
  }

  @Basic
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

    DeptManager that = (DeptManager) o;

    if (deptNo != null ? !deptNo.equals(that.deptNo) : that.deptNo != null) return false;
    if (empNo != null ? !empNo.equals(that.empNo) : that.empNo != null) return false;
    if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
    if (toDate != null ? !toDate.equals(that.toDate) : that.toDate != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = deptNo != null ? deptNo.hashCode() : 0;
    result = 31 * result + (empNo != null ? empNo.hashCode() : 0);
    result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
    result = 31 * result + (toDate != null ? toDate.hashCode() : 0);
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "dept_no", referencedColumnName = "dept_no", nullable = false, insertable = false, updatable = false)
  public Departments getDepartmentsByDeptNo() {
    return departmentsByDeptNo;
  }

  public void setDepartmentsByDeptNo(Departments departmentsByDeptNo) {
    this.departmentsByDeptNo = departmentsByDeptNo;
  }
}
