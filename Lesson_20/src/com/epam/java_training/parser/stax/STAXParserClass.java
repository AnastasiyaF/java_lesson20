package com.epam.java_training.parser.stax;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.epam.java_training.model.Product;
import com.epam.java_training.parser.MenuTagName;

public class STAXParserClass {

	private Product       current_product;
	private List<Product> list_products;
	private MenuTagName   elementName;
	
	public STAXParserClass(){
		this.list_products = new ArrayList<Product>();
		elementName = null;
	}
	
	public List<Product> getList_products() {
		return this.list_products;
	}
	
	public void process(XMLStreamReader reader) throws XMLStreamException {

		System.out.println("STAX parser XML document - start.");
		
		while (reader.hasNext()) {
		
			int type = reader.next();
				
			switch (type) {
				
				case XMLStreamConstants.START_ELEMENT:
					
					this.elementName = MenuTagName.getElementTagName(reader.getLocalName());
					
					System.out.println("elementName: " + this.elementName);
			
					switch (this.elementName) {
					
						
						case PRODUCTDETAIL:
							current_product = new Product();
							current_product.setCode(reader.getAttributeValue(null, "Code"));
							current_product.setName(reader.getAttributeValue(null, "Name"));
							break;
						case COUNTRY:
							current_product.setCountry_code(reader.getAttributeValue(null, "Code"));
							break;
						case PROVIDER:
							current_product.setProvider_name(reader.getAttributeValue(null, "Name"));
							break;
						default:
							break;
					}
					break;
				
				case XMLStreamConstants.CHARACTERS:
						
					String text = reader.getText().trim();
						
					if (text.isEmpty()) {
						break;
					}
						
					switch (this.elementName) {
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
						default:
							break;
					}
					break;
						
				case XMLStreamConstants.END_ELEMENT:
					
					elementName = MenuTagName.getElementTagName(reader.getLocalName());
					
					switch (this.elementName) {
						case PRODUCTDETAIL:
							list_products.add(current_product);
							current_product = null;
						case PRODUCTLIST:
							break;
					default:
						break;
					}
			}
		}
		
		System.out.println("STAX parser XML document - end.");
	}
}