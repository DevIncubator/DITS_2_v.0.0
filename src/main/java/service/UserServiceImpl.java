package service;

import dao.daoImpl.AbstractDAOImpl;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dmitry on 18.02.2018.
 */
@Service
public class UserServiceImpl implements AbstractService<User> {

    @Autowired
    private AbstractDAOImpl<User> abstractDAOImpl;


    @Override
    public void create(User entity) {
        abstractDAOImpl.create(entity);
    }

    @Override
    public List<User> getAll() {
        return abstractDAOImpl.getAll();
    }

    @Override
    public void update(User entity) {
        abstractDAOImpl.update(entity);

    }

    @Override
    public void remove(User entity) {
        abstractDAOImpl.remove(entity);

    }

    @Override
    public void flush() {
        abstractDAOImpl.flush();
    }

    @Override
    public void clear() {
        abstractDAOImpl.clear();
    }
}
