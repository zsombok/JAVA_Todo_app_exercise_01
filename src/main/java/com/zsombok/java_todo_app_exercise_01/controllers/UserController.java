package com.zsombok.java_todo_app_exercise_01.controllers;

import com.zsombok.java_todo_app_exercise_01.models.dtos.UserDTO;
import com.zsombok.java_todo_app_exercise_01.models.entities.User;
import com.zsombok.java_todo_app_exercise_01.models.enums.Gender;
import com.zsombok.java_todo_app_exercise_01.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/add")
    public String saveUser(UserDTO userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setGender(Gender.valueOf(userDto.getGender()));
        user.setBio("");
        System.out.println(user.getId());
        user = userService.save(user);
        System.out.println(user.getId());
        return "todos";
    }

}
