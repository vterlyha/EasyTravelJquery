package dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.ElementDAO;

@Transactional
public abstract class ElementDAOImpl<E, V> implements ElementDAO<E, V> {
	
    private Class<E> elementClass;
	
	@PersistenceContext(unitName = "EasyTourJPA")
	private EntityManager eManager;
	
	public ElementDAOImpl() {
    }
	
	public ElementDAOImpl(Class<E> elementClass) {
		this.elementClass = elementClass;
	}

	@Transactional
	public void addElement(E element) {
	    eManager.persist(element);
	}
	
	@Transactional
	public void updateElement(E element) {
	    eManager.merge(element);
	}

	@Transactional
	public E getElementByID(V elementId) {
		return eManager.find(elementClass, elementId);
	}

	@SuppressWarnings("unchecked")
	@Transactional
    public List<E> getAllElements() {
        List<E> elementEList = new ArrayList<E>();
        Query query = eManager.createQuery("Select e FROM " + elementClass.getName() + " e");
        elementEList = query.getResultList();
        return elementEList;
    }

	public void deleteElement(E element) {
	    eManager.remove(element);
	}
	
	public EntityManager getEntityManager() {
        return eManager;
    }
	
	public void setEntityManager(EntityManager eManager) {
	    this.eManager = eManager;
	}

}
