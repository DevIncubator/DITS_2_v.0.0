package service;

import entity.Entity;

import java.util.List;

/**
 * Service methods
 *
 * @param <E>
 *
 * @author Alex V.
 */

public interface AbstractService<E> extends Entity {

	void create(E entity);

	public List<E> getAll() ;

	void update(E entity);

	void remove(E entity);

	void flush();

	void clear();
}