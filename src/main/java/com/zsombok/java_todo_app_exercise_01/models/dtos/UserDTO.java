package com.zsombok.java_todo_app_exercise_01.models.dtos;

import com.zsombok.java_todo_app_exercise_01.models.entities.Todo;
import com.zsombok.java_todo_app_exercise_01.models.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Integer id;
    private String name;
    private String email;
    private String gender;
    private String bio;
    private List<Todo> todos;

    public UserDTO() {
        todos = new ArrayList<>();
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.gender = user.getGender().name();
        this.bio = user.getBio();
        this.todos = user.getTodos();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
