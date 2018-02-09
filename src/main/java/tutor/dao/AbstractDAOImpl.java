package tutor.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import tutor.model.Entity;

import java.util.List;

/**
 * Implementation of DAO
 *
 * @author Alex V.
 */

@Repository
public class AbstractDAOImpl<E extends Entity> implements AbstractDAO<E> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void create(E entity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(entity);
        logger.info("Question saved successfully, Question Details=" + entity);
    }

    @Override
    public List<E> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<E> entityList = session.createQuery("from Entity").list();
        for (E entity : entityList) {
            logger.info("Question List::" + entity);
        }
        return entityList;
    }

    @Override
    public void update(E entity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(entity);
        logger.info("Entity updated successfully, Entity Details=" + entity);
    }


    @Override
    public void remove(E entity) {
        Session session = this.sessionFactory.getCurrentSession();
        if (null != entity) {
            session.delete(entity);
        }
        logger.info("Entity deleted successfully, entity details=" + entity);
    }


    @Override
    public void flush() {
        Session session = this.sessionFactory.getCurrentSession();
        session.flush();
    }

    @Override
    public void clear() {
        Session session = this.sessionFactory.getCurrentSession();
        session.clear();
    }
}
