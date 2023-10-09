package com.kafka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kafka.dto.CarPostDto;

@Service
public interface CarPostStoreService {
	
	List<CarPostDto> getCarForSales();
	
	void changeCarForSale(CarPostDto carPost , String id);

	
	void removeCarForSale(String id);
}
