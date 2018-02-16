package dao.daoImpl;

import dao.DAOInterface;
import entity.Link;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LinkDAOImpl implements DAOInterface<Link> {

    @Autowired
    private SessionFactory sessionFactory;


    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void create(Link link) {
        currentSession().save(link);
    }

    @Override
    public Link getById(int id) {
        Link link = currentSession().load(Link.class, id);
        return link;
    }

    @Override
    public void update(Link link) {
        currentSession().update(link);
    }

    @Override
    public void delete(int id) {
        currentSession().delete(currentSession().get(Link.class, id));
    }



    /*public LinkDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }*/


    /* @Override
    public void create(Link entity) {
        super.create(entity);
    }

    @Override
    public Link getById(int id) {
        return super.getById(id);
    }

    @Override
    public void update(Link entity) {
        super.update(entity);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }*/

/*public boolean deleteLink(Integer id) {
        Query query = currentSession().createQuery(
                "FROM Link u where :id"
        );
        query.setParameter("id", id);
        return query.executeUpdate() > 0;
    }*/
}
