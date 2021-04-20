package com.jun.products;

public interface ProductLookupTable {

	public void addProduct(final Product productToAdd);
	public Product lookupById(final int id);
}