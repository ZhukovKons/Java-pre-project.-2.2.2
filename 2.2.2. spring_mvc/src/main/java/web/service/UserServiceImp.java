package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import web.dao.UserDao;
//import web.dao.UserDaoEnv;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

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
}
