package com.asr.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.asr.custom.exception.EmployeeNotFoundException;
import com.asr.entity.ApiError;

@ControllerAdvice
@RestController
public class GlobalExceptionHandlerController {
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<ApiError> handledEmployeeNotFoundException() {
		ApiError error = new ApiError(404L, "No employee found in the database ", new Date());
		return new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ApiError> handlingOtherException() {
		ApiError error = new ApiError(400L, "Bad request please review your code or check your url is write ",
				new Date());
		return new ResponseEntity<ApiError>(error, HttpStatus.BAD_REQUEST);
	}
}
