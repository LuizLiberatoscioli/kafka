package com.kafka.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.dto.CarPostDto;
import com.kafka.message.KafkaProducerMessage;
import com.kafka.service.CarPostStoreService;

@RestController
@RequestMapping("/api/car")
public class CarPostController {
	
	@Autowired
	private CarPostStoreService carPostStoreService;
	
	@Autowired
	private KafkaProducerMessage kafkaProducerMessage; 
	
	@PostMapping("/post")
	public ResponseEntity postCarForSale(@RequestBody CarPostDto carPostDto) {
		kafkaProducerMessage.sendMessage(carPostDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<CarPostDto>> getCarSales(){
		return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarForSales());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity changeCarSale(@RequestBody CarPostDto carPostDto, @PathVariable("id") String id) {
		carPostStoreService.changeCarForSale(carPostDto, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteCarForSale(@PathVariable("id") String id) {
		carPostStoreService.removeCarForSale(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
