package com.jun.products;

import static java.util.Comparator.comparing;

import java.util.Comparator;
import java.util.Objects;

public class Product {

	public static final Comparator<Product> BY_NAME = comparing(Product::getName);
	//comparator implementation. either up or down
	public static final Comparator<Product> BY_WEIGHT = new Comparator<Product>() {
		public int compare(Product o1, Product o2) {
			return Integer.compare(o1.getWeight(), o2.getWeight());
		}; 
	};
	
	private final String name;
	private final int weight;
	private int Id = 0;

	public Product(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public Product(int id, String name, int weight) {
		this.Id = id;
		this.name = name;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() { 
		return "Product [name=" + name + ", weight=" + weight + "]";
	}

	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + weight;
		return Objects.hash(name, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return Id;
	}


}
