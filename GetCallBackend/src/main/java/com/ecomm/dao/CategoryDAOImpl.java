package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCategory(Category category) 
	{
		try{
			Session session=sessionFactory.getCurrentSession();
			session.save(category);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.delete(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.update(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Category> getCategoryDetails() 
	{
		Session session=sessionFactory.getCurrentSession();
		List<Category> categoryList=session.createQuery("from Category").list();
		return categoryList;
	}

	@Override
	public Category getCategory(int categoryId) 
	{
		Session session=sessionFactory.getCurrentSession();
		Category category=(Category)session.get(Category.class, categoryId);
		return category;
	}

}
