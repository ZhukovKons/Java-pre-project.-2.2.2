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

    @Transactional
    void add(User user);

    @Transactional
    void edit(User user, long id);

    @Transactional
    void remove(long id);

    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    @Transactional
    void addDefaultRoles();
}
