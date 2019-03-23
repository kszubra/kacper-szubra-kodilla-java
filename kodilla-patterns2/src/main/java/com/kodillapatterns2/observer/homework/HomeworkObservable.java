package com.kodillapatterns2.observer.homework;

public interface HomeworkObservable {
    void registerObserver(HomeworkObserver observer);
    void notifyObservers();
    void removeObserver(HomeworkObserver observer);
}
