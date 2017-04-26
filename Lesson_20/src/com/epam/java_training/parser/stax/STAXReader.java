package com.epam.java_training.parser.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.epam.java_training.model.Product;

public class STAXReader {
	
	private String file_path;
	
	private List<Product> list_products;
	
	public STAXReader(String file_path){
		
		this.file_path = file_path;
		this.list_products = new ArrayList<Product>();
	}
	
	public List<Product> getList_products() {
		return this.list_products;
	}
	
	public void parse(){
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		
		try {
			InputStream input = new FileInputStream(this.file_path);

			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			
			STAXParserClass stax_parser = new STAXParserClass();
			
			stax_parser.process(reader);
			
			this.list_products = stax_parser.getList_products();
		
		} 
		catch (XMLStreamException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void printList_products(){
		
		for (Product product : this.list_products) {
			System.out.println(product);
		}
	}
}
