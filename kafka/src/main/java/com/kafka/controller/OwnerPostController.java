package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.dto.OwnerPostDto;
import com.kafka.service.OwnerPostService;

@RestController
@RequestMapping("/owner")
public class OwnerPostController {
	
	@Autowired
	private OwnerPostService ownerPostService;
	
	@PostMapping
	public ResponseEntity createOwnerCar(@RequestBody OwnerPostDto ownerPostDto) {
		ownerPostService.createOwnerCar(ownerPostDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
