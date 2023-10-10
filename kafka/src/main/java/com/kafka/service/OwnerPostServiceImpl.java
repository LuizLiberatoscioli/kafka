package com.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.client.CarPostStoreCliente;
import com.kafka.dto.OwnerPostDto;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

	@Autowired
	private CarPostStoreCliente carPostStoreCliente;
	
	@Override
	public void createOwnerCar(OwnerPostDto ownerPostDto) {
		
		carPostStoreCliente.ownerPostsCliente(ownerPostDto);
	}

}
