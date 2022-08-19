package com.itc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.main.model.Product;
import com.itc.main.service.ProductService;

@RestController
@RequestMapping("/api/")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> list = this.productService.getProducts();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}

	@PostMapping("saveproduct")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		boolean b = this.productService.saveProduct(product);
		if (b == true)
			return new ResponseEntity<String>("SUCCESSFULLY STORED", HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("NOT FOUND", HttpStatus.INSUFFICIENT_STORAGE);
	}
	
	
	
	@GetMapping("product/{id}")
	public ResponseEntity getProductById(@PathVariable("id") int id){
		   Product product = this.productService.getProductById(id);
		   if(product!=null) {
			   return new ResponseEntity<Product>(product, HttpStatus.OK);
		   }
		   else {
			   return new ResponseEntity<String>("Not Found",HttpStatus.NOT_FOUND);
		   }
	}
	
	@DeleteMapping("product/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id)
	{
		   boolean b = this.productService.deleteById(id);
		   
		   if(b==true) {
			   return new ResponseEntity<>("DELETED SUCCESSFULLY",HttpStatus.OK);
		   }else {
			   return new ResponseEntity<>("ID NOT FOUDND",HttpStatus.NOT_FOUND);
		   }
	}
	
	@PutMapping("updateproduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(this.productService.updateProduct(product),HttpStatus.OK);
		
	}
	

}
