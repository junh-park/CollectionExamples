package com.jun.products;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViewsOverMaps {

	public static void main(String[] args) {
		final Map<Integer, Product> idToProduct = new HashMap<Integer, Product>();
		idToProduct.put(1, ProductFixtures.door);
		idToProduct.put(2, ProductFixtures.floorPanel);
		idToProduct.put(3, ProductFixtures.window);
	
		System.out.println(idToProduct);
		final Set<Integer> ids = idToProduct.keySet();
		System.out.println(ids);
	}
}
