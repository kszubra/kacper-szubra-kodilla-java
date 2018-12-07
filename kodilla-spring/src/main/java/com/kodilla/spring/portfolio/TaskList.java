package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private String listName;
    private List<String> tasks;

    public TaskList(String name) {
        listName = name;
        tasks = new ArrayList<>();
    }

    public void addTask(String taskToAdd) {
        tasks.add(taskToAdd);
    }

    public void displayList() {
        tasks.stream()
                .forEach(e-> System.out.println(listName + ":  " + e));
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getListName() {
        return listName;
    }
}
