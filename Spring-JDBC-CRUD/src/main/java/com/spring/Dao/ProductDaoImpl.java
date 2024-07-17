package com.spring.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.Pojo.Product;
import com.spring.RowMapper.ProductRowMapper;

public class ProductDaoImpl implements ProductDao {

	private JdbcTemplate jdbcTemplate;

	public ProductDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public ProductDaoImpl() {
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(Product product) {
		String sql = "INSERT INTO product VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, product.getId(), product.getName(), product.getCost(), product.getLocation());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Product findById(int id) {
		String sql = "SELECT * FROM product WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new ProductRowMapper());
	}

	@Override
	public List<Product> findAll() {
		String sql = "SELECT * FROM product";
		return jdbcTemplate.query(sql, new ProductRowMapper());
	}

	@Override
	public void update(Product product) {
		String sql = "UPDATE product SET name = ?, cost = ? WHERE id = ?";
		jdbcTemplate.update(sql, product.getName(), product.getCost(), product.getId());
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM product WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

}
