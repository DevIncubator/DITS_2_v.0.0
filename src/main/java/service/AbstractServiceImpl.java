package service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.AbstractDAO;

import java.util.List;

@Service
public class AbstractServiceImpl<E> implements AbstractService<E> {

    private AbstractDAO<E> abstractDAO;

    public void setAbstractDAO(AbstractDAO<E> abstractDAO) {
        this.abstractDAO = abstractDAO;
    }

    @Override
    @Transactional
    public void create(E entity) {
        abstractDAO.create(entity);
    }

    @Override
    @Transactional
    public List<E> getAll() {
        return abstractDAO.getAll();
    }

    @Override
    @Transactional
    public void update(E entity) {
        abstractDAO.update(entity);
    }

    @Override
    @Transactional
    public void remove(E entity) {
        abstractDAO.remove(entity);
    }

    @Override
    @Transactional
    public void flush() {

    }

    @Override
    @Transactional
    public void clear() {

    }
}
