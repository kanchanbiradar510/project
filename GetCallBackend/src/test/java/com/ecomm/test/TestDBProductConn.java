package com.ecomm.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;

import entity.Product;

public class TestDBProductConn 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext();
		appContext.scan("com.ecomm");	
		appContext.refresh();

		Product product=new Product();
		product.setProductName("xyz");
		product.setProductDesc("sdnlk");
		product.setCategoryId(1);
		product.setSupplierId(1);
		product.setPrice(13333);
		product.setStock(1);
		
		ProductDAO productDAO=(ProductDAO)appContext.getBean("productDAO");
		if(productDAO.addProduct(product))
		{
			System.out.println("Object Saved");
		}
		else
		{
			System.out.println("Problem Occured");
		}
		
	}

}
