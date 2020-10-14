package com.ecomm.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CustomerDAO;

import entity.Customer;

public class TestDBCustomerConn 
{

	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext();
		appContext.scan("com.ecomm");	
		appContext.refresh();
		
		Customer customer=new Customer();
		customer.setLoginName("kanchan");
		customer.setPassword("kanch");
		customer.setCustomerName("kanchan biradar");
		customer.setEmailId("kanchan@gmail.com");
		customer.setMobileNo("9921798998");
		customer.setCustomerAddr("shivaji nagar");
		customer.setRole("Admin");
		
		CustomerDAO customerDAO=(CustomerDAO)appContext.getBean("customerDAO");
		if(customerDAO.addCustomer(customer))
		{
			System.out.println("Object Saved");
		}
		else
		{
			System.out.println("Problem Occured");
		}
	}
	
}