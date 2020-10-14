package com.ecomm.dao;

import java.util.List;

import entity.Category;

public interface CategoryDAO 
{
	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public List<Category> getCategoryDetails();
	public Category getCategory(int categoryId);
}
