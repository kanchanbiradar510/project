package com.ecomm.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;

import entity.Category;



public class TestDBConn
{ 

	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext();
		appContext.scan("com.ecomm");	
		appContext.refresh();
		
		Category category=new Category();
		category.setCategoryName("Motorola");
		category.setCategoryDesc("All Models of Motorola Mobiles");
		
		CategoryDAO categoryDAO=(CategoryDAO)appContext.getBean("categoryDAO");
		if(categoryDAO.addCategory(category))
		{
			System.out.println("Object Saved");
		}
		else
		{
			System.out.println("Problem Occured");
		}
	}
	

}
