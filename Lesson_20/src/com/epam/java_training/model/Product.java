package com.epam.java_training.model;

public class Product {
	
	private String code;
	private String name;
	private int    amount;
	private int    price;
	private String description;
	private String type;
	private String status;
	private String country_code;
	private String provider_name;
	
	public Product(){
		
	}
	
	public Product(String code,  String name, int amount, int price, String decription, String type, String status, String country_code, String provider_name){
		
		this.setCode(code);
		this.setName(name);
		this.setAmount(amount);
		this.setPrice(price);
		this.setDescription(decription);
		this.setType(type);
		this.setStatus(status);
		this.setCountry_code(country_code);
		this.setProvider_name(provider_name);
		
	}
	
	public String getCode(){
		
		return this.code;
	}
	
	public void setCode(String code){
		
		this.code = code;
	}
	
	public String getName(){
		
		return this.name;
	}
	
	public void setName(String name){
		
		this.name = name;
	}
	
	public int getAmount(){
		
		return this.amount;
	}
	
	public void setAmount(int amount){
		
		this.amount = amount;
	}
	
	public int getPrice(){
		
		return this.price;
	}
	
	public void setPrice(int price){
		
		this.price = price;
	}
	
	public String getDescription(){
		
		return this.description;
	}
	
	public void setDescription(String description){
		
		this.description = description;
	}
	
public String getType(){
		
		return this.type;
	}
	
	public void setType(String type){
		
		this.type = type;
	}
	
	public String getStatus(){
		
		return this.status;
	}
	
	public void setStatus(String status){
		
		this.status = status;
	}
	
	public String getCountry_code(){
		
		return this.country_code;
	}
	
	public void setCountry_code(String country_code){
		
		this.country_code = country_code;
	}
	
	public String getProvider_name(){
		
		return this.provider_name;
	}
	
	public void setProvider_name(String provider_name){
		
		this.provider_name = provider_name;
	}
	
	@Override
	public String toString() {
		return "code = " + this.code + ", name = " + this.name + ", amount = " + this.amount + ", price = " + this.price +
				", description = " + this.description + ", type = " + this.type + ", status = " + this.status + ", country_code = " + this.country_code +
				", provider_name = " + this.provider_name;
	}
	
	
}
