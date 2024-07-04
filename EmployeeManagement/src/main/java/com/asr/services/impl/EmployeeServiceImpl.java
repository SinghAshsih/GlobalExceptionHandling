package com.asr.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.asr.custom.exception.EmployeeNotFoundException;
import com.asr.dto.EmployeeDto;
import com.asr.entity.Employee;
import com.asr.mapper.EmployeeMapper;
import com.asr.reposotory.EmployeeRepository;
import com.asr.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto create(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public EmployeeDto getById(Long id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for the given id = " + id));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAll() {
		// TODO Auto-generated method stub
		List<Employee> listOfEmployee = employeeRepository.findAll();
		List<EmployeeDto> employeeDto = listOfEmployee.stream().map((e) -> EmployeeMapper.mapToEmployeeDto(e))
				.collect(Collectors.toList());
		return employeeDto;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for the given id = " + id));
		employeeRepository.deleteById(id);

	}

	@Override
	public EmployeeDto update(EmployeeDto employeeDto, Long id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for the given id = " + id));
		employee.setName(employeeDto.getName());
		employee.setEmail(employeeDto.getEmail());
		employee.setAge(employeeDto.getAge());
		employee.setSalary(employeeDto.getSalary());
		Employee updateEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updateEmployee);
	}

}
