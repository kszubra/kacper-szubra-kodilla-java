package com.kodillapatterns2.observer.homework;


import java.util.ArrayList;
import java.util.List;

public class HomeworkQueue implements HomeworkObservable {
    private final List<HomeworkObserver> observers;
    private final List<Homework> homeworks;
    private final Student student;

    public HomeworkQueue(Student student) {
        this.observers = new ArrayList<>();
        this.homeworks = new ArrayList<>();
        this.student = student;
    }

    public void addHomework(Homework homework) {
        homeworks.add(homework);
        notifyObservers();
    }

    public List<Homework> getHomeworks() {
        return homeworks;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public void registerObserver(HomeworkObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(HomeworkObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(HomeworkObserver observer) {
        observers.remove(observer);
    }
}
