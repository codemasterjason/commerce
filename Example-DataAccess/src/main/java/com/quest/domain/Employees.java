package com.quest.domain;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Jason Park
 * @since v
 */
@Entity
public class Employees {
  private Long empNo;
  private Date birthDate;
  private String firstName;
  private String lastName;
  private String gender;
  private Date hireDate;

  @Id
  @Column(name = "emp_no", nullable = false)
  public Long getEmpNo() {
    return empNo;
  }

  public void setEmpNo(Long empNo) {
    this.empNo = empNo;
  }

  @Basic
  @Column(name = "birth_date", nullable = false)
  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  @Basic
  @Column(name = "first_name", nullable = false, length = 14)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Basic
  @Column(name = "last_name", nullable = false, length = 16)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Basic
  @Column(name = "gender", nullable = false)
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Basic
  @Column(name = "hire_date", nullable = false)
  public Date getHireDate() {
    return hireDate;
  }

  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Employees employees = (Employees) o;

    if (empNo != null ? !empNo.equals(employees.empNo) : employees.empNo != null) return false;
    if (birthDate != null ? !birthDate.equals(employees.birthDate) : employees.birthDate != null)
      return false;
    if (firstName != null ? !firstName.equals(employees.firstName) : employees.firstName != null)
      return false;
    if (lastName != null ? !lastName.equals(employees.lastName) : employees.lastName != null)
      return false;
    if (gender != null ? !gender.equals(employees.gender) : employees.gender != null) return false;
    if (hireDate != null ? !hireDate.equals(employees.hireDate) : employees.hireDate != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = empNo != null ? empNo.hashCode() : 0;
    result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (gender != null ? gender.hashCode() : 0);
    result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
    return result;
  }
}
