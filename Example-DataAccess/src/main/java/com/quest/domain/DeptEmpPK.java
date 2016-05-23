package com.quest.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author Jason Park
 * @since v1.0.0
 */
public class DeptEmpPK implements Serializable {
  private int empNo;
  private String deptNo;

  @Column(name = "emp_no", nullable = false)
  @Id
  public int getEmpNo() {
    return empNo;
  }

  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  @Column(name = "dept_no", nullable = false, length = 4)
  @Id
  public String getDeptNo() {
    return deptNo;
  }

  public void setDeptNo(String deptNo) {
    this.deptNo = deptNo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DeptEmpPK deptEmpPK = (DeptEmpPK) o;

    if (empNo != deptEmpPK.empNo) return false;
    if (deptNo != null ? !deptNo.equals(deptEmpPK.deptNo) : deptEmpPK.deptNo != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = empNo;
    result = 31 * result + (deptNo != null ? deptNo.hashCode() : 0);
    return result;
  }
}
