package com.epam.java_training.parser.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.java_training.model.Product;
import com.epam.java_training.parser.MenuTagName;

public class SAXParserClass extends DefaultHandler{
	
	private Product       current_product;
	private List<Product> list_products;
	
	private StringBuilder text;
	
	public SAXParserClass(){
		this.list_products = new ArrayList<Product>();
	}
	
	public List<Product> getList_products() {
		return this.list_products;
	}
	
	public void startDocument() throws SAXException {
		System.out.println("SAX parser XML document - start.");
		
	}
	
	public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) throws SAXException {
		
		System.out.println("startElement -> " + "uri: " + namespaceURI + ", localName: " + localName + ", qName: " + qName);
		
		this.text = new StringBuilder();
		
		if (qName.equals("ProductDetail")){
			current_product = new Product();
			current_product.setCode(attributes.getValue("Code"));
			current_product.setName(attributes.getValue("Name"));
		}
		else if (qName.equals("Country")){
			current_product.setCountry_code(attributes.getValue("Code"));
		}
		else if (qName.equals("Provider")){
			current_product.setProvider_name(attributes.getValue("Name"));
		}
		
	}
	
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
		
		MenuTagName tagName = MenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));
		
		switch(tagName){
		case AMOUNT:
			current_product.setAmount(Integer.parseInt(text.toString()));
			break;	
		case PRICE:
			current_product.setPrice(Integer.parseInt(text.toString()));
			break;
		case DESCRIPTION:
			current_product.setDescription(text.toString());
			break;
		case TYPE:
			current_product.setType(text.toString());
			break;
		case STATUS:
			current_product.setStatus(text.toString());
			break;
		case PRODUCTDETAIL:
			list_products.add(current_product);
			current_product = null;
		case PRODUCTLIST:
			break;
		default:
			break;
		}
		
		this.text = new StringBuilder();
	}
	
	public void endDocument() throws SAXException {
		System.out.println("SAX parse XML document - end.");
		
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		this.text.append(ch, start, length);			
	}
	
	public void warning(SAXParseException exception) {
		System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}
		
	public void error(SAXParseException exception) {
		System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}
	
	public void fatalError(SAXParseException exception) throws SAXException {
		System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
		throw (exception);
	}
}
