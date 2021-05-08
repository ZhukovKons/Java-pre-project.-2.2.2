package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArrTest implements UserDao{

    long idPust = 0;
    private List<User> list = new ArrayList<>();

    public ArrTest() {
        User user;
        for (long i = 1; i < 8; i++) {
            user = new User();
            user.setId(++idPust);
            user.setName("user_" + i);
            user.setLastname("last name" + i);
            user.setEmail(i + "_us@ru.ru");
            list.add(user);
        }
    }

    @Override
    public List<User> getAll() {
        return list;
    }

    @Override
    public User getUser(long id) {
        return list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void add(User user) {
        user.setId(++idPust);
        list.add(user);
    }

    @Override
    public void edit(User user, long id) {
        //System.out.println("Edit: " + user.toString());
        User userOld = getUser(id);
        userOld.setName(user.getName());
        userOld.setLastname(user.getLastname());
        userOld.setEmail(user.getEmail());
    }

    @Override
    public void remove(long id) {
        list.removeIf(x -> x.getId() == id);
        //System.out.println("Delete: " + list.get((int) id).toString());
    }
}
