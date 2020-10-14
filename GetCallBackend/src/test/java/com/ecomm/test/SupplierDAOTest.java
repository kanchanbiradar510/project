package com.ecomm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.SupplierDAO;

import entity.Supplier;

public class SupplierDAOTest 
{
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext();
		appContext.scan("com.ecomm");	
		appContext.refresh();
		supplierDAO=(SupplierDAO)appContext.getBean("supplierDAO");
	}

	@Ignore
	@Test
	public void addSupplier()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Real Me");
		supplier.setSupplierDesc("All Mobile Brands of RealMe");
		
		assertTrue("Problem in Inserting Supplier",supplierDAO.addSupplier(supplier));
	}
	
	@Test
	public void getSupplierTest()
	{
		Supplier supplier=(Supplier)supplierDAO.getSupplier(5);
		assertNotNull("supplier object not Found",supplier);
		System.out.println("Supplier Name:"+supplier.getSupplierName());
		System.out.println("Supplier Desc:"+supplier.getSupplierDesc());
	}
	
	@Test
	public void getCatgoryList()
	{
		List<Supplier> supplierList=(List<Supplier>)supplierDAO.getSupplierDetails();
		
		for(Supplier supplier:supplierList)
		{
			System.out.print("Supplier Name:"+supplier.getSupplierName());
			System.out.println("::::Supplier Desc:"+supplier.getSupplierDesc());
		}
	}
}
