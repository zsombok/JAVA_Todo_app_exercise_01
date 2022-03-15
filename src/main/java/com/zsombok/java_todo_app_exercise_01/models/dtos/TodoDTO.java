package com.zsombok.java_todo_app_exercise_01.models.dtos;

import com.zsombok.java_todo_app_exercise_01.models.entities.User;
import com.zsombok.java_todo_app_exercise_01.models.enums.Priority;

import java.time.LocalDateTime;

public class TodoDTO {

    private String title;
    private String body;
    private LocalDateTime deadline;
    private Priority priority;
    private User owner;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = LocalDateTime.parse(deadline);
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
