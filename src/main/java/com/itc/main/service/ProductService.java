package com.itc.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itc.main.model.Product;

@Service
public class ProductService {

	private List<Product> list;

	public ProductService() {
		list = new ArrayList<>();
		list.add(new Product(1001, "Mobile", 10000));
		list.add(new Product(1002, "Laptop", 45000));
		list.add(new Product(1003, "TV", 10000));
		list.add(new Product(1004, "Smart Watch", 3000));
		list.add(new Product(1005, "Book", 500));
	}

	public List<Product> getProducts() {
		return this.list;
	}

	public boolean saveProduct(Product product) {
		return list.add(product);
	}

	public Product getProductById(int id) {

		for (Product product : list) {
			if (product.getPid() == id)
				return product;
		}
		return null;

	}

	public boolean deleteById(int id) {

		for (Product product : list) {
			if (product.getPid() == id) {
				return list.remove(product);
			}
		}
		return false;
	}

	public Product updateProduct(Product product) {

		int indexPos = -1;

		for (int i = 0; i < list.size(); i++) {
			Product pr = list.get(i);
			if (pr.getPid() == product.getPid()) {
				indexPos = i;
				list.set(i, product);
				break;
			}
		}
		return product;

	}

}
