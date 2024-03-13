package org.jsp.merchantbootapp.repository;

import java.util.List;

import org.jsp.merchantbootapp.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("select p from Product p where p.merchant.id=?1")
	public List<Product> findProductsByMerchantId(int mid) ;
	
	@Query("select p from Product p where p.name=?1")
	public List<Product> findByName(String name) ;
	
	@Query("select p from Product p where p.brand=?1")
	public List<Product> findByBrand(String brand);
	
	@Query("select p from Product p where p.merchant.phone=?1 and p.merchant.password=?2")
	public List<Product> findProductsByMerchantPhone(long phone, String password) ;
}
