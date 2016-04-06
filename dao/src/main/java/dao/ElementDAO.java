package dao;

import java.util.List;

public interface ElementDAO<E, V> {

	public void addElement(E element);

	public void updateElement(E element);

	public E getElementByID(V elementId);

	public List<E> getAllElements();

	public void deleteElement(E element);
}
