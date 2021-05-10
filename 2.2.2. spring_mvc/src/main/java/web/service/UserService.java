package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUser(long id);
    @Transactional
    void add (User user);
    @Transactional
    void edit (User user, long id);
    @Transactional
    void remove (long id);
}
