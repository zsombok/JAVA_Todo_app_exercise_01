package com.zsombok.java_todo_app_exercise_01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class JavaTodoAppExercise01Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JavaTodoAppExercise01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
