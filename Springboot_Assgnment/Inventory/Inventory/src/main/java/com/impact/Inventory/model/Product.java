package com.impact.Inventory.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.impact.Inventory.DTO.ProductDTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(schema = "Inventory")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	Integer id;

	@Column(name = "Description")
	String description;

	@Column(name = "Weight")
	Integer weight;

	@Column(name = "Price")
	Double price;

	@Column(name = "Manufacture_Date")
	LocalDate manufactureDate;

	@Column(name = "Use_Before_Month")
	Integer useBeforeMonth;

	@Column(name = "Expiry_Date")
	LocalDate expiryDate;

	public ProductDTO toDto() {
		ProductDTO dto = new ProductDTO();
		if (this.id != null) {
			dto.setId(this.id);
		} else if (this.description != null) {
			dto.setDescription(this.description);
		} else if (this.weight != null) {
			dto.setWeight(this.weight);
		} else if (this.price != null) {
			dto.setPrice(this.price);
		} else if (this.manufactureDate != null) {
			dto.setManufactureDate(this.manufactureDate);
		} else if (this.useBeforeMonth != null) {
			dto.setUseBeforeMonth(this.useBeforeMonth);
		} else if (this.expiryDate != null) {
			dto.setExpiryDate(this.expiryDate);
		}
		return dto;
	}
}
