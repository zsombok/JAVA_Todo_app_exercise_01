package com.zsombok.java_todo_app_exercise_01.repositories;

import com.zsombok.java_todo_app_exercise_01.models.entities.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoDbRepository extends CrudRepository<Todo, Integer> {
}
