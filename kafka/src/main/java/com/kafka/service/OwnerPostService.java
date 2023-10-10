package com.kafka.service;

import org.springframework.stereotype.Service;

import com.kafka.dto.OwnerPostDto;

@Service
public interface OwnerPostService {

	 default void createOwnerCar(OwnerPostDto ownerPostDto) {
		
	}
	
}
