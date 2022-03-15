package com.zsombok.java_todo_app_exercise_01.controllers;

import com.zsombok.java_todo_app_exercise_01.models.dtos.TodoDTO;
import com.zsombok.java_todo_app_exercise_01.models.entities.Todo;
import com.zsombok.java_todo_app_exercise_01.models.enums.Priority;
import com.zsombok.java_todo_app_exercise_01.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/add")
    public String renderAddTodoPage(Model model) {
        model.addAttribute("priorities", Priority.values());
        model.addAttribute("owner", 1);
        return "addTodo";
    }

    @PostMapping
    public String saveTodo(@ModelAttribute TodoDTO todoDTO) {
        Todo todo = new Todo();
        todo.setTitle(todoDTO.getTitle());
        todo.setBody(todoDTO.getBody());
        todo.setDeadline(todoDTO.getDeadline());
        todo.setPriority(todoDTO.getPriority());
        todo.setOwner(todoDTO.getOwner());
        todoService.save(todo);
        return String.format("redirect:/users/%d/todos", 1);
    }
}
