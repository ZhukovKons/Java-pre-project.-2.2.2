package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import web.dao.UserDao;
import web.model.User;

import java.util.*;

@Service
public class UserServiceImp implements UserService {

    @Qualifier("userDaoEntityManagerImpl") //todo - UserDao dao;
    //@Qualifier("arrayDao")
    @Autowired
    private UserDao dao;

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
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
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException { //todo loadUserByUsername - перенести в бд, а эту хуйню удалить
        return dao.findUserByLogin(s);
    }
}
