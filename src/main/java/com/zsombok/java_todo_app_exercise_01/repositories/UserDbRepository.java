package com.zsombok.java_todo_app_exercise_01.repositories;

import com.zsombok.java_todo_app_exercise_01.models.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDbRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
