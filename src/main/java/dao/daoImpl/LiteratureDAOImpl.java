package dao.daoImpl;

import dao.LiteratureDAOInterface;
import org.springframework.stereotype.Repository;
import user.model.Literature;

@Repository
public class LiteratureDAOImpl implements LiteratureDAOInterface {
    @Override
    public void create(Literature object) {

    }

    @Override
    public Literature getById(int id) {
        return null;
    }

    @Override
    public void update(Literature object) {

    }

    @Override
    public void delete(int id) {

    }
}
