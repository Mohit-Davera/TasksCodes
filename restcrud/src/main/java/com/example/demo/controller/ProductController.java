package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService prodService;
	
	
//	CREATE

	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return prodService.saveProduct(product);
	}

	@PostMapping("/products")
	public List<Product> addProduct(@RequestBody List<Product> product) {
		return prodService.saveProducts(product);
	}
	
//	READ

	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return prodService.getProducts();
	}
	
	@GetMapping(value = {"/products/page/{page}","/products/page/{page}/{sortBy}"})
	public Page<Product> findAllProducts(
			@PathVariable Integer page,
			@PathVariable Optional<String> sortBy
			) {
		return prodService.getProductsPaginated(page-1,sortBy);
	}

	@GetMapping("/products/{id:[0-9]+}")
	public Product findProductById(@PathVariable int id) {
		return prodService.getProductById(id);
	}

	@GetMapping("/products/{name:[A-Za-z]+}")
	public List<Product> findProductByName(@PathVariable String name) {
		return prodService.getProductsByName(name);
	}
	
//	UPDATE
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product) {
		return prodService.updateProduct(product);
	}
	
//	DELETE
	
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable int id) {
		return prodService.deleteProduct(id);
	}
}
