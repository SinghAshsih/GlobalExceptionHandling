package com.asr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asr.dto.EmployeeDto;
import com.asr.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeSerive;

	@PostMapping("/create")
	ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto cretaeEmployee = employeeSerive.create(employeeDto);
		return new ResponseEntity<EmployeeDto>(cretaeEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	ResponseEntity<List<EmployeeDto>> getAll() {
		List<EmployeeDto> listOfEmployee = employeeSerive.getAll();
		return new ResponseEntity<List<EmployeeDto>>(listOfEmployee, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	ResponseEntity<EmployeeDto> getById(@PathVariable Long id) {
		EmployeeDto employee = employeeSerive.getById(id);
		return new ResponseEntity<EmployeeDto>(employee, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id) {
		employeeSerive.deleteById(id);
		return new ResponseEntity<String>("Delete Successfilly", HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto employeeDto,@PathVariable Long id) {
		// EmployeeDto updateeEmployee = employeeSerive.getById(id);
		EmployeeDto updateEmployee = employeeSerive.update(employeeDto,id);
		return new ResponseEntity<EmployeeDto>(updateEmployee, HttpStatus.CREATED);
	}

}
