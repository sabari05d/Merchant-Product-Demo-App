package org.jsp.merchantbootapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.merchantbootapp.dto.Product;
import org.jsp.merchantbootapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public Product updateProduct(Product product) {
		return repository.save(product);
	}
	
	public Optional<Product> findById(int id) {
		return repository.findById(id);
	}
	
	public boolean deleteProduct(int id) {
		Optional<Product> dbProduct = findById(id);
		if(dbProduct.isPresent()) {
			repository.delete(dbProduct.get());
			return true;
		}
		return false;
	}
	
	public List<Product> findAllProducts() {
		return repository.findAll();
	}

	public List<Product> findByBrand(String brand) {
		return repository.findByBrand(brand);
	}
	
	public List<Product> findByName(String name) {
		return repository.findByName(name);
	}
	
	public List<Product> findProductByMerchantId(int mid) {
		return repository.findProductsByMerchantId(mid);
	}
	
	public List<Product> findProductsByMerchantPhone(long phone, String password) {
		return repository.findProductsByMerchantPhone(phone, password);
	}
}
