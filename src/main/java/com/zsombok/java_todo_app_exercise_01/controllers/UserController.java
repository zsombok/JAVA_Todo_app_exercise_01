package com.zsombok.java_todo_app_exercise_01.controllers;

import com.zsombok.java_todo_app_exercise_01.exceptions.NoSuchUserException;
import com.zsombok.java_todo_app_exercise_01.models.dtos.RegisterDTO;
import com.zsombok.java_todo_app_exercise_01.models.dtos.UserDTO;
import com.zsombok.java_todo_app_exercise_01.models.entities.User;
import com.zsombok.java_todo_app_exercise_01.models.enums.Gender;
import com.zsombok.java_todo_app_exercise_01.services.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public String saveUser(Model model, @ModelAttribute RegisterDTO registerDTO) {
        User user = new User();
        user.setName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setGender(Gender.valueOf(registerDTO.getGender()));
        user.setBio("");
        try {
            user = userService.save(user);
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "User already exist!");
            return "registration";
        }
        return String.format("redirect:/users/%d/todos", user.getId());
    }

    @GetMapping("/{userId}/todos")
    public String renderTodosPage(@PathVariable Integer userId, Model model) {
        UserDTO userDTO;
        try {
            userDTO = new UserDTO(userService.findById(userId));

            model.addAttribute("user", userDTO);
            model.addAttribute("todos", userDTO.getTodos());
            return "todos";
        } catch (NoSuchUserException e) {
            return "redirect:/";
        }
    }
}
