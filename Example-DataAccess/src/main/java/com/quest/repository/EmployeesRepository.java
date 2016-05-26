package com.quest.repository;

import com.quest.domain.Employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

}
