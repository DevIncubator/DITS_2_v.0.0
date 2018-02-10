package dao;

import java.util.List;

/**
 * Created by Dmitry on 08.02.2018.
 */
public interface DAOInterface<T> {

    public void create(T object);

    public T getById(int id);

    public void update(T object);

    public void delete(int id);

}
