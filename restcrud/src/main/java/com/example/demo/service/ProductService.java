package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
//	CREATE

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}

//	READ
	
	public List<Product> getProducts() {
		return repository.findAll();
	}

	public Page<Product> getProductsPaginated(Integer page, Optional<String> sortBy) {

		try {
			
			PageRequest pr = PageRequest.of(page, 10, Sort.Direction.ASC, sortBy.orElse("id"));
			return repository.findAll(pr);
			
		} catch (org.springframework.data.mapping.PropertyReferenceException e) {
			
			sortBy = Optional.ofNullable("id");
			System.out.println(sortBy);
			PageRequest pr = PageRequest.of(page, 10, Sort.Direction.ASC, sortBy.orElse("id"));
			return repository.findAll(pr);
			
		}
		
	}

	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Product> getProductsByName(String name) {
		return repository.findAllByName(name);
	}
	
//	UPDATE
	
	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);

		if (product.getName() == "" || product.getName() == null)
			product.setName(existingProduct.getName());
		if (product.getPrice() == 0)
			product.setPrice(existingProduct.getPrice());
		if (product.getQuantity() == 0)
			product.setQuantity(existingProduct.getQuantity());

		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return repository.save(existingProduct);

	}
//	DELETE
	
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Product Removed With ID : " + id;
	}
}
