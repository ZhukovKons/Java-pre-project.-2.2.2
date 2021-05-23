package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.Role;
import web.model.User;
import web.service.UserService;;
import java.util.Collections;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    UserService service;

    @GetMapping
    public String addAdmin() {
        service.addDefaultRoles();
        service.add(new User("Admin", "Admin_Last", "admin@admin", "admin", Collections.singleton(new Role(1L, "ROLE_ADMIN"))));
        for (int i = 1; i < 25; i++) {
            service.add(new User("Пользователь " + i, "Фамилия " + i, i + "@user", "p" + i, Collections.singleton(new Role(2L, "ROLE_USER"))));
        }
        return "redirect:/";
    }

}
