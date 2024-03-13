package org.jsp.merchantbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.merchantbootapp.dao.MerchantDao;
import org.jsp.merchantbootapp.dao.ProductDao;
import org.jsp.merchantbootapp.dto.Merchant;
import org.jsp.merchantbootapp.dto.Product;
import org.jsp.merchantbootapp.dto.ResponceStructure;
import org.jsp.merchantbootapp.exception.IdNotFountException;
import org.jsp.merchantbootapp.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	@Autowired
	private MerchantDao merchantDao;

	public ResponseEntity<ResponceStructure<Product>> saveProduct(Product product, int mid) {
		Optional<Merchant> recMerchant = merchantDao.findById(mid);
		ResponceStructure<Product> structure = new ResponceStructure<>();
		if (recMerchant.isPresent()) {
			Merchant merchant = recMerchant.get();
			merchant.getProducts().add(product);
			product.setMerchant(merchant);
			productDao.saveProduct(product);
			structure.setMessage("Product Added Succesfully!!");
			structure.setData(product);
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponceStructure<Product>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFountException();
	}

	public ResponseEntity<ResponceStructure<Product>> updateProduct(Product product) {
		Optional<Product> recProduct = productDao.findById(product.getId());
		ResponceStructure<Product> structure = new ResponceStructure<>();
		if (recProduct.isPresent()) {
			Product dbProduct = recProduct.get();
			dbProduct.setName(product.getName());
			dbProduct.setBrand(product.getBrand());
			dbProduct.setCategory(product.getCategory());
			dbProduct.setCost(product.getCost());
			dbProduct.setDescription(product.getDescription());
			dbProduct.setImg_url(product.getImg_url());
			productDao.updateProduct(dbProduct);
			structure.setMessage("Product Updated Succesfully!!");
			structure.setData(dbProduct);
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponceStructure<Product>>(structure, HttpStatus.ACCEPTED);
		}
		throw new ProductNotFoundException("Invalid Product ID!!");
	}

	public ResponseEntity<ResponceStructure<Product>> findById(int id) {
		Optional<Product> recProduct = productDao.findById(id);
		ResponceStructure<Product> structure = new ResponceStructure<>();
		if (recProduct.isPresent()) {
			structure.setMessage("Product Found!!");
			structure.setData(recProduct.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<Product>>(structure, HttpStatus.OK);
		}
		throw new ProductNotFoundException("Invalid Product ID!!");
	}

	public ResponseEntity<ResponceStructure<List<Product>>> findAllProducts() {
		List<Product> recProducts = productDao.findAllProducts();
		ResponceStructure<List<Product>> structure = new ResponceStructure<>();
		if(recProducts.size() > 0) {
			structure.setMessage("Products Found!!!");
			structure.setData(recProducts);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<List<Product>>>(structure, HttpStatus.OK);
		}
		throw new ProductNotFoundException("Product Not Found!!");
	}
	
	public ResponseEntity<ResponceStructure<List<Product>>> findByName(String name) {
		List<Product> recProducts = productDao.findByName(name);
		ResponceStructure<List<Product>> structure = new ResponceStructure<>();
		if(recProducts.size() > 0) {
			structure.setMessage("Products Found!!!");
			structure.setData(recProducts);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<List<Product>>>(structure, HttpStatus.OK);
		}
		throw new ProductNotFoundException("Product Not Found with the Given Name!!");
	}
	
	public ResponseEntity<ResponceStructure<List<Product>>> findByBrand(String brand) {
		List<Product> recProducts = productDao.findByBrand(brand);
		ResponceStructure<List<Product>> structure = new ResponceStructure<>();
		if(recProducts.size() > 0) {
			structure.setMessage("Products Found!!!");
			structure.setData(recProducts);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<List<Product>>>(structure, HttpStatus.OK);
		}
		throw new ProductNotFoundException("Product Not Found with the Given Brand!!");
	}
	
	public ResponseEntity<ResponceStructure<List<Product>>> findProductsByMerchantId(int mid) {
		List<Product> recProducts = productDao.findProductByMerchantId(mid);
		ResponceStructure<List<Product>> structure = new ResponceStructure<>();
		if(recProducts.size() > 0) {
			structure.setMessage("Products Found!!!");
			structure.setData(recProducts);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<List<Product>>>(structure, HttpStatus.OK);
		}
		throw new ProductNotFoundException("No Products Found with the Given Merchant Id!!");
	}
	
	
	public ResponseEntity<ResponceStructure<List<Product>>> findProductsByMerchantPhone(long phone, String password) {
		List<Product> recProducts = productDao.findProductsByMerchantPhone(phone, password);
		ResponceStructure<List<Product>> structure = new ResponceStructure<>();
		if(recProducts.size() > 0) {
			structure.setMessage("Products Found!!!");
			structure.setData(recProducts);
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<List<Product>>>(structure, HttpStatus.OK);
		}
		throw new ProductNotFoundException("No Products Found with the Given Merchant Phone/password");
	}
	
	
}
