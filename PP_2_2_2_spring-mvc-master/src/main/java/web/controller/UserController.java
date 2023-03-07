package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.service.UsersService;
import org.springframework.ui.Model;
import web.model.Users;
import javax.validation.Valid;
@Controller
public class UserController {
    private final UsersService userService;
    @Autowired
    public UserController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String usersALL(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String usersId(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", userService.getUserId(id));
        return "users";
    }

    @GetMapping("/new")
    public String addUser(Users users) {
        return "create";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("users") Users users) {
        userService.addUser(users);
        return "redirect:/";

    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String updateUser(Model model, @PathVariable("id") long id) {
        model.addAttribute(userService.getUserId(id));
        return "edit";
    }


    @PatchMapping("/edit")
    public String update(@Valid Users users, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            userService.updateUser(users);
            return "redirect:/";
        }
    }
}
