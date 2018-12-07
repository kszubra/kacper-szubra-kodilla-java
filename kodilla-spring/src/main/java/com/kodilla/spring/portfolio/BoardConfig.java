package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {
    @Autowired
    @Qualifier("toDoList")
    TaskList toDoTaskList;
    @Autowired
    @Qualifier("inProgressList")
    TaskList inProgressTaskList;
    @Autowired
    @Qualifier("doneList")
    TaskList doneTaskList;

    @Bean
    public Board getBoard() {
        return new Board(toDoTaskList, inProgressTaskList, doneTaskList);
    }

    @Bean(name = "toDoList")
    @Scope("prototype")
    public TaskList getToDoTaskList() {
        return new TaskList("toDoList");
    }

    @Bean(name = "inProgressList")
    @Scope("prototype")
    public TaskList getInProgressTaskList() {
        return new TaskList("inProgressList");
    }

    @Bean(name = "doneList")
    @Scope("prototype")
    public TaskList getDoneTaskList() {
        return new TaskList("doneList");
    }

}
