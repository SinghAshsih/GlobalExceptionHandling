package com.asr.services;

import java.util.List;

import com.asr.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto create(EmployeeDto employeeDto);

	EmployeeDto getById(Long id);

	List<EmployeeDto> getAll();

	

	void deleteById(Long id);

	EmployeeDto update(EmployeeDto employeeDto, Long id);

}
