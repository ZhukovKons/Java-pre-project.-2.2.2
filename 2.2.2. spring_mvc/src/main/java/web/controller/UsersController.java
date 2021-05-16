package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;

import javax.validation.Valid;
import java.security.Principal;


@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getAllUsers(Model model, @ModelAttribute("userNew") User userNew) {
        model.addAttribute("userList", userService.getAll());
        return "/index";
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
        return "redirect:/";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("userNew") @Valid User userNew,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/index";
        }
        userService.add(userNew);
        return "redirect:/";

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        System.out.println("delete @DeleteMapping");
        userService.remove(id);

        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(value = "/user")
    public String getUserPage(Model model, Principal principal) {
        model.addAttribute("userName", principal.getName());
        return "user";
    }

    @GetMapping("/admin")
    public String dontLoginUser(Model model, Principal principal){
        model.addAttribute("userName", principal.getName());
        return "admin";
    }
}
