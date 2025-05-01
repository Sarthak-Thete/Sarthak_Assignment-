package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Tour {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length=50)
	private String packageName;
	
	@Column(length=50)
	private String duration;
	
	@Column
	private int price;
	
	@Enumerated(EnumType.STRING)
	private TransportationType type;

	public Tour() {
		
	}

	public Tour(int id, String packageName, String duration, int price, TransportationType type) {
		super();
		this.id = id;
		this.packageName = packageName;
		this.duration = duration;
		this.price = price;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public TransportationType getType() {
		return type;
	}

	public void setType(TransportationType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TourPackage [id=" + id + ", packageName=" + packageName + ", duration=" + duration + ", price=" + price
				+ ", type=" + type + "]";
	}
	
	

}
