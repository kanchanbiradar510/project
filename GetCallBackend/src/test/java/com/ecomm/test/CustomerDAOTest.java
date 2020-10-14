package com.ecomm.test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ecomm.dao.CustomerDAO;

import entity.Customer;

public class CustomerDAOTest 
{
	static CustomerDAO customerDAO;

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext();
		appContext.scan("com.ecomm");	
		appContext.refresh();
		customerDAO=(CustomerDAO)appContext.getBean("customerDAO");
	}
@Ignore
@Test
public void addCustomer()
{
	Customer customer=new Customer();
	
	customer.setLoginName("kanchan");
	customer.setPassword("kanch");
	customer.setCustomerName("kanchan biradar");
	customer.setEmailId("kanchan@gmail.com");
	customer.setMobileNo("9921798998");
	customer.setCustomerAddr("shivaji nagae");
	customer.setRole("Admin");
	
	
	assertTrue("Problem in Inserting Customer",customerDAO.addCustomer(customer));
}


@Test
public void getCustomerTest()
{
	Customer customer=(Customer)customerDAO.getCustomer(1);
	assertNotNull("customer object not Found",customer);
	System.out.println("Customer ID"+customer.getCustomerId());
	System.out.println("Login Name:"+customer.getLoginName());
	System.out.println("Password:"+customer.getPassword());
	System.out.println("Customer Name:"+customer.getCustomerName());
	System.out.println("Email ID:"+customer.getEmailId());
	System.out.println("Mobile No:"+customer.getMobileNo());
	System.out.println("Customer Addr:"+customer.getCustomerAddr());
	System.out.println("Role:"+customer.getRole());
}

@Test
public void getCustomerList()
{
	List<Customer> customerList=(List<Customer>)customerDAO.getCustomerDetails();
	
	for(Customer customer:customerList)
	{
		System.out.println("Customer ID"+customer.getCustomerId());
		System.out.println("::::Login Name:"+customer.getLoginName());
		System.out.println("::::Password:"+customer.getPassword());
		System.out.println("::::Customer Name:"+customer.getCustomerName());
		System.out.println("::::Email ID:"+customer.getEmailId());
		System.out.println("::::MObile No:"+customer.getMobileNo());
		System.out.println("::::Customer Addr:"+customer.getCustomerAddr());
		System.out.println("::::Role:"+customer.getRole());
	}
}
}