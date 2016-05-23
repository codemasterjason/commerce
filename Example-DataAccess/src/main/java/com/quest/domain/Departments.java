package com.quest.domain;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@Entity
public class Departments {
  private String deptNo;
  private String deptName;
  private Collection<DeptEmp> deptEmpsByDeptNo;
  private Collection<DeptManager> deptManagersByDeptNo;

  @Id
  @Column(name = "dept_no", nullable = false, length = 4)
  public String getDeptNo() {
    return deptNo;
  }

  public void setDeptNo(String deptNo) {
    this.deptNo = deptNo;
  }

  @Basic
  @Column(name = "dept_name", nullable = false, length = 40)
  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Departments that = (Departments) o;

    if (deptNo != null ? !deptNo.equals(that.deptNo) : that.deptNo != null) return false;
    if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = deptNo != null ? deptNo.hashCode() : 0;
    result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
    return result;
  }

  @OneToMany(mappedBy = "departmentsByDeptNo")
  public Collection<DeptEmp> getDeptEmpsByDeptNo() {
    return deptEmpsByDeptNo;
  }

  public void setDeptEmpsByDeptNo(Collection<DeptEmp> deptEmpsByDeptNo) {
    this.deptEmpsByDeptNo = deptEmpsByDeptNo;
  }

  @OneToMany(mappedBy = "departmentsByDeptNo")
  public Collection<DeptManager> getDeptManagersByDeptNo() {
    return deptManagersByDeptNo;
  }

  public void setDeptManagersByDeptNo(Collection<DeptManager> deptManagersByDeptNo) {
    this.deptManagersByDeptNo = deptManagersByDeptNo;
  }
}
