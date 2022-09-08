package com.impact.Inventory.controller;

import java.util.Optional;

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

import com.impact.Inventory.DTO.ProductDTO;
import com.impact.Inventory.model.Product;
import com.impact.Inventory.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<String> addProduct(@RequestBody ProductDTO dto) {
		productService.addProduct(dto);
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public void deleteExpiredProducts() {
		productService.removeExpiredProduct();
	}
	
	@PutMapping
	public void applyDiscounts() {
		productService.applyDiscounts();
	}
	
	@GetMapping("/{id}")
	public Optional<Product> getProduct(@PathVariable int id){
		return productService.searchById(id);
	}
}
