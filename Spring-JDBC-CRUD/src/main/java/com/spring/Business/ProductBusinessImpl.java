package com.spring.Business;

import java.util.List;

import com.spring.Dao.ProductDao;
import com.spring.Pojo.Product;

public class ProductBusinessImpl implements ProductBusiness {

	private ProductDao productDao;

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void saveProduct(Product product) {
		productDao.save(product);
	}

	@Override
	public Product findProductsById(int id) {
		return productDao.findById(id);
	}

	@Override
	public List<Product> findAllProducts() {
		return productDao.findAll();
	}

	@Override
	public void updateProduct(Product product) {
		productDao.update(product);
	}

	@Override
	public void deleteProduct(int id) {
		productDao.delete(id);
	}

}
