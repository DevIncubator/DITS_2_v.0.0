package service;

import dao.daoImpl.AbstractDAOImpl;
import entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dmitry on 18.02.2018.
 */
@Service
public class RoleServiceImpl implements AbstractService<Role> {

    AbstractDAOImpl<Role> abstractDAOImpl;

    @Override
    public void create(Role entity) {
        abstractDAOImpl.create(entity);
    }

    @Override
    public List<Role> getAll() {
        return abstractDAOImpl.getAll();
    }

    @Override
    public void update(Role entity) {
        abstractDAOImpl.update(entity);

    }

    @Override
    public void remove(Role entity) {
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
