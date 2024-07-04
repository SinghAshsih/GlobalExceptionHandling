package com.asr.mapper;

import com.asr.dto.EmployeeDto;
import com.asr.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		EmployeeDto empDto = new EmployeeDto(employee.getId(), employee.getName(), employee.getAge(),
				employee.getSalary(), employee.getEmail());
		return empDto;
	}

	public static Employee mapToEmployee(EmployeeDto empDto) {
		Employee employee = new Employee(empDto.getId(), empDto.getEmail(), empDto.getAge(), empDto.getSalary(),
				empDto.getName());
		return employee;
	}
}
