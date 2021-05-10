package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoEntityManagerImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> getAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void edit(User user, long id) {
        entityManager.merge(user);
    }

    @Override
    public void remove(long id) {
        entityManager.remove(getUser(id));
    }
}
