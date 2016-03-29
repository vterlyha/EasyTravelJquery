package com.java.tour_firm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ElementDAOImpl<E> implements ElementDAO<E> {
	
	private Class<E> elementClass;
	private EntityManager eManager;
	private EntityTransaction eTransaction = null;
	private EntityManagerFactory emf;
	
	public ElementDAOImpl() {
    }
	
	public ElementDAOImpl(Class<E> elementClass) {
		this.elementClass = elementClass;
		emf = Persistence.createEntityManagerFactory( "EasyTourJPA" );
	}

	public void addElement(E element) {
		
		eManager = emf.createEntityManager();
		try {
			eTransaction = eManager.getTransaction();
			eTransaction.begin();
			eManager.merge(element);
			eTransaction.commit();
		}
		catch(RuntimeException e) {
			if (eTransaction.isActive())
				eTransaction.rollback();
			throw e;
		}
	}

	public void updateElement(E element) {
		
		eManager = emf.createEntityManager();
		try {
			eTransaction = eManager.getTransaction();
			eTransaction.begin();
			eManager.merge(element);
			eTransaction.commit();
		}
		catch(RuntimeException e) {
			if (eTransaction.isActive())
				eTransaction.rollback();
			throw e;
		}
	}

	public E getElementByID(Integer elementId) {
		
		E elementE = null;
		eManager = emf.createEntityManager();
		try {
			eTransaction = eManager.getTransaction();
			eTransaction.begin();
			elementE = eManager.find(elementClass, elementId);
			eTransaction.commit();
		}
		catch(RuntimeException e) {
			if (eTransaction.isActive())
				eTransaction.rollback();
			throw e;
		}
		return elementE;
	}

	public List<E> getAllElements() {
		
		eManager = emf.createEntityManager();
		List<E> elementEList = new ArrayList<E>();
		try {
			eTransaction = eManager.getTransaction();
			eTransaction.begin();
			Query query = eManager.createQuery("Select e FROM "
					+ elementClass.getName() + " e");
			elementEList = query.getResultList();
			eTransaction.commit();
		}
		catch(RuntimeException e) {
			if (eTransaction.isActive())
				eTransaction.rollback();
			throw e;
		}
		return elementEList;
	}

	public void deleteElement(E element) {
	
		eManager = emf.createEntityManager();
		try {
			eTransaction = eManager.getTransaction();
			eTransaction.begin();
			eManager.remove(eManager.contains(element) ? element : eManager.merge(element));
			
			eTransaction.commit();
		}
		catch(RuntimeException e) {
			if (eTransaction.isActive())
				eTransaction.rollback();
			throw e;
		}
	}

}
