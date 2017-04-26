package com.epam.java_training.parser;

public enum MenuTagName {
	CODE, NAME, AMOUNT, PRICE, DESCRIPTION, TYPE, STATUS, PRODUCTDETAIL, PRODUCTLIST, ADDITIONALINFO, COUNTRY, PROVIDER;
	
	public static MenuTagName getElementTagName(String element) {
		
		switch (element) {
			case "Code": return CODE;
			case "Name": return NAME;
			case "Amount": return AMOUNT;
			case "Price": return PRICE;
			case "Description": return DESCRIPTION;
			case "Type": return TYPE;
			case "Status": return STATUS;
			case "ProductDetail": return PRODUCTDETAIL;
			case "ProductList": return PRODUCTLIST;
			case "AdditionalInfo": return ADDITIONALINFO;
			case "Country": return COUNTRY;
			case "Provider": return PROVIDER;
			
			default: throw new EnumConstantNotPresentException(MenuTagName.class, element);
		}
	}
}
