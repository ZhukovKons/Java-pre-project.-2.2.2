package web.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import java.util.*;

@Repository
public class ArrayDao implements UserDao {

    private final Map<String, User> userMap = new HashMap<>();

    {
        userMap.put("a",
                new User(1L, "Aaaa", "Abbbb", "a", "a", Collections.singleton(new Role(1L, "ROLE_USER")))); // name - уникальное значение, выступает в качестве ключа Map
        userMap.put("q",
                new User(2L, "Baaa", "Bbbbbbb", "q", "q" //"$2y$12$/7bSgCvHLYTi3E9L0uzvmeXEI/FPtqHVUahg3VPbzeIwz.pJJkAsG"
                        , Collections.singleton(new Role(2L, "ROLE_ADMIN")))); // name - уникальное значение, выступает в качестве ключа Map
        Set<Role> roles = new HashSet<Role>();
        roles.add(new Role(3L, "ROLE_ADMIN"));
        roles.add(new Role(3L, "ROLE_USER"));
        userMap.put("c@c",
                new User(3L, "Caaaa", "Cbbbb", "c@c", "c", roles)); // name - уникальное значение, выступает в качестве ключа Map
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<User>(userMap.values());
    }

    @Override
    public User getUser(long id) {
        return new ArrayList<User>(userMap.values()).stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void add(User user) {
        print("add!");
    }

    @Override
    public void edit(User user, long id) {
        print("Edit");
    }

    @Override
    public void remove(long id) {
        print("remove");
    }

    @Override
    public UserDetails findUserByLogin(String s) {
        if (!userMap.containsKey(s)) {
            return null;
        }
        System.out.println("userMap.get(s) = " + userMap.get(s));
        return (UserDetails) userMap.get(s);
    }

    private void print(String m) {
        System.out.println(m);
    }

}
