package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    public TaskList toDoList() {
        return new TaskList();
    }

    public TaskList doneList() {
        return new TaskList();
    }

    public TaskList  inProgressList() {
        return new TaskList();
    }

    @Bean
    public Board getLists() {
        return new Board(toDoList(), doneList(), inProgressList());
    }
}
