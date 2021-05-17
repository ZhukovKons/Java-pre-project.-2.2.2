package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import web.dao.UserDao;
import web.model.Role;
import web.model.User;
import web.model.UserTest;

import java.util.*;

@Service
public class UserServiceImp implements UserService, UserDetailsService {

    private final Map<String, UserTest> userMap = new HashMap<>();

    { //fixme создание пользователей в Мар
        userMap.put("q",
                new UserTest(1L, "Vladimir", "q", Collections.singleton(new Role(1L, "ROLE_USER")))); // name - уникальное значение, выступает в качестве ключа Map
        userMap.put("qq",
                new UserTest(2L, "Vladimir", "qq" //"$2y$12$/7bSgCvHLYTi3E9L0uzvmeXEI/FPtqHVUahg3VPbzeIwz.pJJkAsG"
                        , Collections.singleton(new Role(2L, "ROLE_ADMIN")))); // name - уникальное значение, выступает в качестве ключа Map
        Set<Role> roles = new HashSet<Role>();
        roles.add(new Role(3L, "ROLE_ADMIN"));
        roles.add(new Role(3L, "ROLE_USER"));
        userMap.put("aa",
                new UserTest(3L, "Alan", "aa", roles)); // name - уникальное значение, выступает в качестве ключа Map
    }
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
        System.out.println("loadUserByUsername(String s) = " + s);
        if (!userMap.containsKey(s)) {
            return null;
        }
        System.out.println("userMap.get(s) = " + userMap.get(s));
        return userMap.get(s);
    }
}
