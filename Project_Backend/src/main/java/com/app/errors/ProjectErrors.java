package com.app.errors;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Component
public class ProjectErrors {

	public ResponseEntity<Map<String, String>> handleErrors(BindingResult result) {
		if (result.hasErrors()) {

			Map<String, String> errorsMap = new HashMap<>();
			for (FieldError fe : result.getFieldErrors()) {
				errorsMap.put(fe.getField(), fe.getDefaultMessage());
			}

			return new ResponseEntity<Map<String, String>>(errorsMap, HttpStatus.BAD_REQUEST);
		}
		return null;
	}

}
