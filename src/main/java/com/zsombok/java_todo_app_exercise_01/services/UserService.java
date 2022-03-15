package com.zsombok.java_todo_app_exercise_01.services;

import com.zsombok.java_todo_app_exercise_01.exceptions.NoSuchUserException;
import com.zsombok.java_todo_app_exercise_01.exceptions.PasswordMismatchException;
import com.zsombok.java_todo_app_exercise_01.models.dtos.LoginDTO;
import com.zsombok.java_todo_app_exercise_01.models.entities.User;

public interface UserService {
    User save(User user);

    User findUserByLoginDTO(LoginDTO loginDto) throws NoSuchUserException, PasswordMismatchException;
}
