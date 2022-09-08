package com.impact.Inventory.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impact.Inventory.DTO.ProductDTO;
import com.impact.Inventory.exception.ItemNotFoundException;
import com.impact.Inventory.model.Product;
import com.impact.Inventory.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void addProduct(ProductDTO dto) {
		LocalDate expiryDate = calculateExpiryDate(dto);
		dto.setExpiryDate(expiryDate);
		Product product = dto.toEntity();
		productRepository.save(product);
	}

	public void removeExpiredProduct() {
		LocalDate today = LocalDate.now();
		productRepository.deleteByExpiryDateBefore(today);
	}

	public List<Product> sortProducts() {
		return productRepository.findAllOrderByExpiryDate();
	}

	public void applyDiscounts() {

		List<Product> productList = productRepository.findAll();
		LocalDate today = LocalDate.now();
		productList.stream().filter(p -> Period.between(p.getExpiryDate(), today).getMonths() <= 6).forEach(p -> {
			Optional<Product> prod = productRepository.findById(p.getId());
			try {
				p = prod.orElseThrow(() -> new ItemNotFoundException("Item Not Found"));
			} catch (ItemNotFoundException e) {
				e.printStackTrace();
			}
			p.setPrice(p.getPrice() - ((20 / 100) * p.getPrice()));
			productRepository.save(p);
		});

	}

	public Optional<Product> searchById(int productId) {
		return productRepository.findById(productId);
	}

	private LocalDate calculateExpiryDate(ProductDTO dto) {
		return dto.getManufactureDate().plusMonths(dto.getUseBeforeMonth());
	}
}
