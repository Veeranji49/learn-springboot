package com.spring.Business;

import java.util.List;

import com.spring.Pojo.Product;

public interface ProductBusiness {

	public void saveProduct(Product product);

	public Product findProductsById(int id);

	public List<Product> findAllProducts();

	public void updateProduct(Product product);

	public void deleteProduct(int id);

}
