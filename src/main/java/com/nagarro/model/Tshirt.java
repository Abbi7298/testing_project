package com.nagarro.model;

import javax.persistence.Entity;

import javax.persistence.Id;
//import javax.persistence.Table;


@Entity

public class Tshirt {
	@Id
	private String id;
	private String name;
	private String color;
	private String gender;
	private String size;
	private Double price;
	private Double rating;
	private String availability;

	public Tshirt(String id, String name, String color, String gender, String size, Double price, Double rating,
			String availability) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.setAvailability(availability);
	}

	public Tshirt() {
		super();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String toString() {
		return this.id + "\t" + this.name + "\t" + this.color + "\t" + this.gender + "\t" + this.size + "\t"
				+ this.price + "\t" + this.rating;
	}

}