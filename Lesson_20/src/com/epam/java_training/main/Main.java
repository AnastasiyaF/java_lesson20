/*
 *  Created by Anastasiya Findziukevich
 *  24/04/2017
 *  
 *  Task 20.
 *  
 *  –аспарсите xml-файл, содержащий ассортимент магазина проката спортивных товаров в помощью SAX и StAX парсеров.
 */

package com.epam.java_training.main;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.epam.java_training.parser.sax.SAXReader;
import com.epam.java_training.parser.stax.STAXReader;


public class Main {
	
	public static void main(String[] args) {
		
		try{
			
			SchemaFactory schema_factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			
			Source stream_source = new StreamSource(new File("src/com/epam/java_training/ProductsSchema.xsd"));
			Schema schema = schema_factory.newSchema(stream_source);
			
			Validator validator = schema.newValidator();
			
			validator.validate(new StreamSource(new File("src/com/epam/java_training/Products.xml")));
			
			System.out.println("XML document is validated.");
			
			// SAX parser
			
			SAXReader sax_reader = new SAXReader("src/com/epam/java_training/Products.xml");
			sax_reader.parse();
			sax_reader.printList_products();
			
			// STAX parser
			
			STAXReader stax_reader = new STAXReader("src/com/epam/java_training/Products.xml");
			stax_reader.parse();		
			stax_reader.printList_products();
		}
		catch (SAXException e) {
			e.printStackTrace();
		}
		catch (IOException e){
			System.out.println(e);
		}

	}
}
