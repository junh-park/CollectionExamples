package com.jun.products;

import static com.jun.products.ProductFixtures.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import com.jun.products.ProductCatalogue;

public class ProductCatalogueTest  {

	@Before
	public void setUp() {
		ProductCatalogue catalogue = new ProductCatalogue();
	}
	
	@Test
	public void shouldOnlyHoldUniqueProducts() throws Exception{
		ProductCatalogue catalogue = new ProductCatalogue();

		catalogue.isSuppliedBy(bobs);
		catalogue.isSuppliedBy(kates);

		assertThat(catalogue, containsInAnyOrder(door, floorPanel, window));
	}

	@Test
	public void shouldFindLIghtVanProduct() throws Exception {
		
	}
	
}
