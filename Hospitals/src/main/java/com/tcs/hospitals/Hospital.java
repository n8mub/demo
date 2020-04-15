package com.tcs.hospitals;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hospital implements Comparable<Hospital> {
	@Id @GeneratedValue
	private int id;
	private String name;
	private String city;
	private double rating;

	public Hospital(int id, String name, String city, double rating) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.rating = rating;
	}

	public Hospital() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public int compareTo(Hospital o) {
		return Integer.compare(o.id, id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Hospital) {
			Hospital hospital = (Hospital) obj;
			return Integer.compare(hospital.id, id) == 0;
		} else {
			return false;
		}
	}

}
