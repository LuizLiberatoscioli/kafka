package com.kafka.client;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.kafka.dto.CarPostDto;
import com.kafka.dto.OwnerPostDto;

@Component
public class CarPostStoreCliente {
	
	private final String USER_STORE_SERVICE_URI = "http://localhost:8080/user";
	private final String POST_STORE_SERVICE_URI = "http://localhost:8080/sales";
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<CarPostDto> carForSaleCliente (){
		ResponseEntity<CarPostDto[]> responseEntity = restTemplate.getForEntity(POST_STORE_SERVICE_URI +"/cars", CarPostDto[].class);
				return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
	}
	
	public void ownerPostsCliente(OwnerPostDto newUser) {
		restTemplate.postForEntity(POST_STORE_SERVICE_URI, newUser, OwnerPostDto.class);
		
	}
	
	public void changeForSaleClient (CarPostDto carPostDto, String id) {
		restTemplate.put(USER_STORE_SERVICE_URI+ "/car/"+id, carPostDto, CarPostDto.class);
		
	}
	
	public void deleteCarForSaleClient(String id) {
		restTemplate.delete(POST_STORE_SERVICE_URI+"/car/"+id);
	}
	
	
}
