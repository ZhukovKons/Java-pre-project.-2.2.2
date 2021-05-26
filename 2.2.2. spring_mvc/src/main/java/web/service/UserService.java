package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAll();

    User getUser(long id);

    void add(User user);

    void edit(User user, long id);

    void remove(long id);

    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    void addDefaultRoles();
}
