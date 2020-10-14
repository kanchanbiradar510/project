package com.ecomm.dao;

import java.util.List;


import entity.Product;

public interface ProductDAO 
{

	
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public List<Product> getProductDetails();
	public Product getProduct(int productId);
}

