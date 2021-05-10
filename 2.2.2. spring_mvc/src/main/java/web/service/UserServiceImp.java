package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Qualifier("userDaoEntityManagerImpl")
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

    @Transactional
    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Transactional
    @Override
    public void edit(User user, long id) {
        dao.edit(user, id);
    }

    @Transactional
    @Override
    public void remove(long id) {
        dao.remove(id);
    }
}
