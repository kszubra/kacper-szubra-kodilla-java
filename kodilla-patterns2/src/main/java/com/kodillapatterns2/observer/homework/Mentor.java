package com.kodillapatterns2.observer.homework;

public class Mentor implements HomeworkObserver {
    private String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    @Override
    public void update(HomeworkQueue homeworkQueue) {
        System.out.println(name + ": New homework added to " + homeworkQueue.getStudent().getName() + "'s queue: " + homeworkQueue.getLastAddedHomework().getTaskName());
        updateCount++;
    }
}
