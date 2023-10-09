package com.kafka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.client.CarPostStoreCliente;
import com.kafka.dto.CarPostDto;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {
	
	@Autowired
	private CarPostStoreCliente carPostStoreClient;

	@Override
	public List<CarPostDto> getCarForSales() {
		return carPostStoreClient.carForSaleCliente();
	}

	@Override
	public void changeCarForSale(CarPostDto carPost, String id) {
		 carPostStoreClient.changeForSaleClient(carPost, id);
		
	}

	@Override
	public void removeCarForSale(String id) {
		carPostStoreClient.deleteCarForSaleClient(id);
		
	}

}
