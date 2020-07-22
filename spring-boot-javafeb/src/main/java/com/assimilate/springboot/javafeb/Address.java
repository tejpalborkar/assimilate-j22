package com.assimilate.springboot.javafeb;

import org.springframework.stereotype.Component;

@Component
public class Address {

	private String city = "Pune";
	private String state = "Maharashtra";
	private String country = "India";

	public Address() {
		System.out.println("Address constructor called...");
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", country=" + country + "]";
	}

}
