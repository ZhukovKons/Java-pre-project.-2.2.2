package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.*;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Qualifier("userDaoEntityManagerImpl")
    @Autowired
    private UserDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(long id) {
        return dao.getUser(id);
    }

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public void edit(User user, long id) {
        dao.edit(user, id);
    }

    @Override
    public void remove(long id) {
        dao.remove(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return dao.findUserByLogin(s);
    }

    @Override
    public void addDefaultRoles() {
        dao.addRole("ROLE_ADMIN");
        dao.addRole("ROLE_USER");
    }
}
