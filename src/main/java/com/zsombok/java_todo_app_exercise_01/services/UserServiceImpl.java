package com.zsombok.java_todo_app_exercise_01.services;

import com.zsombok.java_todo_app_exercise_01.exceptions.NoSuchUserException;
import com.zsombok.java_todo_app_exercise_01.exceptions.PasswordMismatchException;
import com.zsombok.java_todo_app_exercise_01.models.dtos.LoginDTO;
import com.zsombok.java_todo_app_exercise_01.models.entities.User;
import com.zsombok.java_todo_app_exercise_01.repositories.UserDbRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDbRepository userDbRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserDbRepository userDbRepository, PasswordEncoder passwordEncoder) {
        this.userDbRepository = userDbRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public User save(User user) {
        return userDbRepository.save(user);
    }

    @Override
    public User findUserByLoginDTO(LoginDTO loginDto) throws NoSuchUserException, PasswordMismatchException {
        User user = userDbRepository.findByEmail(loginDto.getEmail()).orElseThrow(NoSuchUserException::new);
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) throw new PasswordMismatchException();
        return user;
    }

    @Override
    public User findById(Integer id) throws NoSuchUserException {
        return userDbRepository.findById(id).orElseThrow(NoSuchUserException::new);
    }
}
