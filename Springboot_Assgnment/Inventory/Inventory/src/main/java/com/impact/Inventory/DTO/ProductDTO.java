package com.impact.Inventory.DTO;

import java.time.LocalDate;

import com.impact.Inventory.model.Product;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {

	Integer id;

	String description;

	Integer weight;

	Double price;

	LocalDate manufactureDate;

	Integer useBeforeMonth;

	LocalDate expiryDate;

	public Product toEntity() {
		Product product = new Product();
		if (this.id != null) {
			product.setId(this.id);
		} else if (this.description != null) {
			product.setDescription(this.description);
		} else if (this.weight != null) {
			product.setWeight(this.weight);
		} else if (this.price != null) {
			product.setPrice(this.price);
		} else if (this.manufactureDate != null) {
			product.setManufactureDate(this.manufactureDate);
		} else if (this.useBeforeMonth != null) {
			product.setUseBeforeMonth(this.useBeforeMonth);
		} else if (this.expiryDate != null) {
			product.setExpiryDate(this.expiryDate);
		}

		return product;
	}

}
