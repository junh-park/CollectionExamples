package com.jun.products;

import static com.jun.products.Product.BY_NAME;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;;

public class ProductCatalogue implements Iterable<Product>{

//	private final Set<Product> products = new HashSet<>();
	private final Set<Product> products = new TreeSet<Product>(BY_NAME);
	
	public void isSuppliedBy(Supplier supplier) {
		products.addAll(supplier.products());
	}

	public Iterator<Product> iterator(){
		return products.iterator();
	}
}
