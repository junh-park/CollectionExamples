package com.jun.products;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Product> {

	private static final int LIGHT_VAN_MAX_WEIGHT = 20;
	private final int PRODUCT_NOT_FOUND = -1;

	private final List<Product> products = new ArrayList<Product>();
	private List<Product> lightVanProducts;
	private List<Product> heavyVanProducts;
	
	public void add(Product product) {
		products.add(product);
	}

	public void replace(Product oldProduct, Product newProduct) {
		int index = products.indexOf(oldProduct);
		if (index != PRODUCT_NOT_FOUND)
			products.set(index, newProduct);
	}

	public void prepare() {
		// Collections.sort(products, Product.BY_WEIGHT); or
		products.sort(Product.BY_WEIGHT);
		int splitPoint = findSplitPoint();
		lightVanProducts = products.subList(0, splitPoint);
		heavyVanProducts = products.subList(splitPoint, products.size());
	}

	private int findSplitPoint() {
//		Iterator<Product> iterator = products.iterator();
//		int i = 0;
//		while (iterator.hasNext()) {
//			Product product = products.get(i);
//			if (product.getWeight() > LIGHT_VAN_MAX_WEIGHT) {
//				return i;
//			}
//			i++;
//		}
//		return 0;
		
		for(int i=0; i<products.size();i++) {
			Product product = products.get(i);
			if(product.getWeight()>LIGHT_VAN_MAX_WEIGHT)
				return i;
		}
		return 0;
	}

	public List<Product> getLightVanProducts() {
		return lightVanProducts;
	}

	public List<Product> getHeavyVanProducts() {
		return heavyVanProducts;
	}

	@Override
	public Iterator<Product> iterator() {
		return products.iterator();
	}
}
