package dao;

import entity.Entity;

import java.util.List;

/**
 * CRUD methods
 * @param <E>
 *
 * @author Alex V.
 */

public interface AbstractDAO<E> extends Entity {

    void create(E entity);

    public List<E> getAll() ;

    void update(E entity);

    void remove(E entity);

    void flush();

    void clear();
}