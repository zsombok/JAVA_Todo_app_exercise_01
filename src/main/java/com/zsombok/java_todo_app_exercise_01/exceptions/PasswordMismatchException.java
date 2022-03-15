package com.zsombok.java_todo_app_exercise_01.exceptions;

public class PasswordMismatchException extends RuntimeException {

    public PasswordMismatchException() {
        super("Wrong password");
    }
}
