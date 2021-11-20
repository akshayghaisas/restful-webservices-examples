package com.springboot.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example.model.Product;

@RestController
public class ProductController {
	
	private static Map<String, Product> productRepo = new HashMap<>();
	
	static {
		
		Product breakPeddle = new Product();
		breakPeddle.setId("100");
		breakPeddle.setName("disc break peddle");
		productRepo.put(breakPeddle.getId(), breakPeddle);
		
		Product transmissionTypes = new Product();
		transmissionTypes.setId("101");
		transmissionTypes.setName("transmission type");
		productRepo.put(transmissionTypes.getId(), transmissionTypes);
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<Object> getAllProducts(){
	
		return new ResponseEntity<>(ProductController.productRepo, HttpStatus.OK);
	}
	

}
