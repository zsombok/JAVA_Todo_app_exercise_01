package com.zsombok.java_todo_app_exercise_01.services;

import com.zsombok.java_todo_app_exercise_01.models.entities.Todo;
import com.zsombok.java_todo_app_exercise_01.repositories.TodoDbRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoDbRepository todoDbRepository;

    public TodoServiceImpl(TodoDbRepository todoDbRepository) {
        this.todoDbRepository = todoDbRepository;
    }

    @Override
    public Todo save(Todo todo) {
        return todoDbRepository.save(todo);
    }
}
