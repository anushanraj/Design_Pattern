package com.impact.Inventory.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impact.Inventory.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	void deleteByExpiryDateBefore(LocalDate today);

	List<Product> findAllOrderByExpiryDate();

}
