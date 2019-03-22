package com.kodillapatterns2.observer.homework;

public class Homework {
    private String taskName;
    private String description;

    public Homework(String taskName) {
        this.taskName = taskName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }
}
