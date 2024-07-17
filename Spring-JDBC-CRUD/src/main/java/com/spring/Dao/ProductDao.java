package com.spring.Dao;

import java.util.List;

import com.spring.Pojo.Product;

public interface ProductDao {

	public void save(Product product);
	public void update(Product product);
	public void delete(int id);
	public Product findById(int id);
	public List<Product> findAll();
}
