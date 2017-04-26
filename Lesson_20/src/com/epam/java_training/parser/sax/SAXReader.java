package com.epam.java_training.parser.sax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.epam.java_training.model.Product;


public class SAXReader {
	
	private String file_path;
	private File file;
	
	private List<Product> list_products;
	
	public SAXReader(String file_path){
		
		this.file_path = file_path;
		this.file = new File(this.file_path);
		this.list_products = new ArrayList<Product>();
	}
	
	public List<Product> getList_products() {
		return this.list_products;
	}
	
	
	public void parse(){
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		SAXParser saxParser;
		
		SAXParserClass saxParserClass = new SAXParserClass();
		
		try {
			saxParser = saxFactory.newSAXParser();
			saxParser.parse(this.file, saxParserClass);
				
			this.list_products = saxParserClass.getList_products();
			
		} 
		catch (ParserConfigurationException e) {
			System.out.println("Parsing fails: ParserConfigurationException - " + e.getMessage());
		}
		catch (SAXException e) {
			System.out.println("Parsing fails: SAXException - " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Parsing fails: IOException - " + e.getMessage());
		}
		
	}
	
	public void printList_products(){
		
		for (Product product : this.list_products) {
			System.out.println(product);
		}
	}
	
	
}
