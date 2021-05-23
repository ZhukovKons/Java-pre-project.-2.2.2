package web.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import web.model.Role;
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
        user.setRoles(getUser(id).getRoles());
        if (getRoleFoName(user.getAddRole()) != null) {
            user.getRoles().add(getRoleFoName(user.getAddRole()));
        }
        if (getRoleFoName(user.getDeleteRole()) != null) {
            user.getRoles().remove(getRoleFoName(user.getDeleteRole()));
        }
        entityManager.merge(user);
    }

    @Override
    public void remove(long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public UserDetails findUserByLogin(String s) {
        return (User) entityManager.createQuery("select u from User u where u.email = :email")
                .setParameter("email", s).getSingleResult();
    }

    @Override
    public void addRole(String role) {
        entityManager.persist(new Role(role));
    }

    private Role getRoleFoName(String nameRole) {
        return entityManager.createQuery("select r from Role r where r.role = :role").setParameter("role", nameRole).getResultList().isEmpty() ?
                null : (Role) entityManager.createQuery("select r from Role r where r.role = :role").setParameter("role", nameRole).getSingleResult();
    }
}
