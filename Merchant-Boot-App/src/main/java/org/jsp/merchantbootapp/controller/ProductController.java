package org.jsp.merchantbootapp.controller;

import java.util.List;

import org.jsp.merchantbootapp.dto.Product;
import org.jsp.merchantbootapp.dto.ResponceStructure;
import org.jsp.merchantbootapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService  productService;
	
	@PostMapping("/{mid}")
	public ResponseEntity<ResponceStructure<Product>> saveProduct(@RequestBody Product product,@PathVariable int mid) {
		return productService.saveProduct(product, mid);
	}
	
	@PutMapping
	public ResponseEntity<ResponceStructure<Product>> updateProduct(Product product) {
		return productService.updateProduct(product);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponceStructure<Product>> findById(@PathVariable int  id) {
		return productService.findById(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponceStructure<List<Product>>> findAllProducts() {
		return productService.findAllProducts();
	}
	
	@GetMapping("/find-by-name/{name}")
	public ResponseEntity<ResponceStructure<List<Product>>> findByName(@PathVariable String name) {
		return productService.findByName(name);
	}
	@GetMapping("/find-by-brand/{brand}")
	public ResponseEntity<ResponceStructure<List<Product>>> findByBrand(@PathVariable String brand) {
		return productService.findByBrand(brand);
	}
	
	@GetMapping("/find-by-merchant-id/{mid}")
	public ResponseEntity<ResponceStructure<List<Product>>> findProductsByMerchantId(@PathVariable int mid) {
		return productService.findProductsByMerchantId(mid);
	}
	
	public ResponseEntity<ResponceStructure<List<Product>>> findProductsByMerchantPhone(@RequestParam long phone,String password) {
		return productService.findProductsByMerchantPhone(phone, password);
	}
	
	
}
