package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getAllUsers(Model model, @ModelAttribute("userNew") User userNew) {
        model.addAttribute("userList", userService.getAll());
        return "/users";
    }

    @GetMapping("/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/user";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") long id) {
        if (bindingResult.hasErrors()) {
            return "/user";
        }
        userService.edit(user, id);
        return "redirect:/users";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("userNew") @Valid User userNew,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return null;
        }
        userService.add(userNew);
        return "redirect:/users";

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        System.out.println("delete @DeleteMapping");
        userService.remove(id);

        return "redirect:/users";
    }
}
