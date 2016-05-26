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
@Table(name = "dept_emp", schema = "employees", catalog = "")
@IdClass(DeptEmpPK.class)
public class DeptEmp {
  private Long empNo;
  private String deptNo;
  private Date fromDate;
  private Date toDate;
  private Departments departmentsByDeptNo;

  @Id
  @Column(name = "emp_no", nullable = false)
  public Long getEmpNo() {
    return empNo;
  }

  public void setEmpNo(Long empNo) {
    this.empNo = empNo;
  }

  @Id
  @Column(name = "dept_no", nullable = false, length = 4)
  public String getDeptNo() {
    return deptNo;
  }

  public void setDeptNo(String deptNo) {
    this.deptNo = deptNo;
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

    DeptEmp deptEmp = (DeptEmp) o;

    if (empNo != null ? !empNo.equals(deptEmp.empNo) : deptEmp.empNo != null) return false;
    if (deptNo != null ? !deptNo.equals(deptEmp.deptNo) : deptEmp.deptNo != null) return false;
    if (fromDate != null ? !fromDate.equals(deptEmp.fromDate) : deptEmp.fromDate != null)
      return false;
    if (toDate != null ? !toDate.equals(deptEmp.toDate) : deptEmp.toDate != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = empNo != null ? empNo.hashCode() : 0;
    result = 31 * result + (deptNo != null ? deptNo.hashCode() : 0);
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
