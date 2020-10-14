package com.ecomm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ecomm.dao.ProductDAO;

import entity.Product;

public class ProductDAOTest 
{
	static ProductDAO productDAO;

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext();
		appContext.scan("com.ecomm");	
		appContext.refresh();
		productDAO=(ProductDAO)appContext.getBean("productDAO");
	}

@Ignore
@Test
public void addproduct()
{
	Product product=new Product();
	product.setProductName("xyz");
	product.setProductDesc("sdnlk");
	product.setCategoryId(1);
	product.setSupplierId(1);
	product.setPrice(13333);
	product.setStock(1);
	
	assertTrue("Problem in Inserting product",productDAO.addProduct(product));
}


@Test
public void getproductTest()
{
	Product product=(Product)productDAO.getProduct(1);
	assertNotNull("product object not Found",product);
	System.out.println("product Name:"+product.getProductName());
	System.out.println("product Desc:"+product.getProductDesc());
	System.out.println("category Id:"+product.getCategoryId());
	System.out.println("supplier Id:"+product.getSupplierId());
	System.out.println("price:"+product.getPrice());
	System.out.println("stock:"+product.getStock());
}

@Test
public void getproductList()
{
	List<Product> productList=(List<Product>)productDAO.getProductDetails();
	
	for(Product product:productList)
	{
		System.out.print("product Name:"+product.getProductName());
		System.out.println("::::product Desc:"+product.getProductDesc());
		System.out.println("::::category Id:"+product.getCategoryId());
		System.out.println("::::supplier Id:"+product.getSupplierId());
		System.out.println("::::price:"+product.getPrice());
		System.out.println("::::stock:"+product.getStock());
		
	}
}
}
