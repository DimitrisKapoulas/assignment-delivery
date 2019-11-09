package com.springboot.offers.crudoffers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="offer")
public class Offer {
	
	//define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="code")
	private int code;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private int price;
		
	@Column(name="expiration")
	private String expiration;
	
	@Column(name="availability")
	private String availability;

	
	//define constructors
	
	public Offer () {
		
	}

	//id will be auto-generated for next inserts to the DB
	public Offer(String name, int price, String expiration, String availability) {
		this.name = name;
		this.price = price;
		this.expiration = expiration;
		this.availability = availability;
	}
	
	
	//define getter/setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	
	//define toString
	
	@Override
	public String toString() {
		return "Offer [name=" + name + ", price=" + price + ", code=" + code + ", expiration=" + expiration
				+ ", availability=" + availability + "]";
	}
	
	
	
}
