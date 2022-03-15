package com.zsombok.java_todo_app_exercise_01.exceptions;

public class NoSuchUserException extends RuntimeException {

    public NoSuchUserException() {
        super("No such registered user!");
    }
}
