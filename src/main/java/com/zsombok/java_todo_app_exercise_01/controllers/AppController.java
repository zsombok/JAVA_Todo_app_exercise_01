package com.zsombok.java_todo_app_exercise_01.controllers;

import com.zsombok.java_todo_app_exercise_01.exceptions.NoSuchUserException;
import com.zsombok.java_todo_app_exercise_01.exceptions.PasswordMismatchException;
import com.zsombok.java_todo_app_exercise_01.models.dtos.LoginDTO;
import com.zsombok.java_todo_app_exercise_01.models.entities.User;
import com.zsombok.java_todo_app_exercise_01.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    private final UserService userService;

    public AppController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String renderDefaultPage() {
        return "login";
    }

    @GetMapping("/login")
    public String renderLoginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String renderRegistrationPage() {
        return "registration";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute LoginDTO loginDto, Model model) {
        User user;
        try {
            user = userService.findUserByLoginDTO(loginDto);
            model.addAttribute("user", user);
        } catch (NoSuchUserException | PasswordMismatchException e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
        return String.format("redirect:/users/%d/todos", user.getId());
    }
}
