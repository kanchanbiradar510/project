package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Supplier;

@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addSupplier(Supplier supplier) 
	{
		try{
			Session session=sessionFactory.getCurrentSession();
			session.save(supplier);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.update(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Supplier> getSupplierDetails() 
	{
		Session session=sessionFactory.getCurrentSession();
		List<Supplier> supplierList=session.createQuery("from Supplier").list();
		return supplierList;
	}

	@Override
	public Supplier getSupplier(int supplierId) 
	{
		Session session=sessionFactory.getCurrentSession();
		Supplier supplier=(Supplier)session.get(Supplier.class, supplierId);
		return supplier;
	}

}
