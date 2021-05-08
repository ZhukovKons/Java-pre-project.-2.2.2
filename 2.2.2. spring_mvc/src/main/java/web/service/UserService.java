package web.service;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUser(long id);
    void add (User user);
    void edit (User user, long id);
    void remove (long id);
}
