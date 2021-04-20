package com.jun.products;

import java.util.ArrayList;
import java.util.List;

public class Supplier {

	private String name;
	private List<Product> products = new ArrayList<Product>();

	public Supplier(String salutation) {
		this.name = salutation;
	}

	public List<Product> products() {
		return products;
	}
	
	
}
