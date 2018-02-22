package service;

import dao.daoImpl.AbstractDAOImpl;
import entity.Statistic;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dmitry on 18.02.2018.
 */
@Service
public class StatisticServiceImpl implements AbstractService<Statistic> {

    private AbstractDAOImpl<Statistic> abstractDAOImpl;

    @Override
    public void create(Statistic entity) {
        abstractDAOImpl.create(entity);
    }

    @Override
    public List<Statistic> getAll() {
        return abstractDAOImpl.getAll();
    }

    @Override
    public void update(Statistic entity) {
        abstractDAOImpl.update(entity);

    }

    @Override
    public void remove(Statistic entity) {
        abstractDAOImpl.remove(entity);

    }

    @Override
    public void flush() {
        abstractDAOImpl.flush();

    }

    @Override
    public void clear() {
        abstractDAOImpl.flush();
    }
}
