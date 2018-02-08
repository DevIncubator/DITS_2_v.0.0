package dao;

/**
 * Created by Dmitry on 08.02.2018.
 */
public interface DAOInterface<T> {

    void create(T object);

    T getById(int id);

    void update(T object);

    void delete(int id);
}
