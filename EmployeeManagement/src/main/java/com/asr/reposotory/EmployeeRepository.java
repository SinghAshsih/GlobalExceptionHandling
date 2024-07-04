package com.asr.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asr.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
