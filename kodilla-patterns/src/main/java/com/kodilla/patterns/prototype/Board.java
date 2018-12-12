package com.kodilla.patterns.prototype;

import java.util.HashSet;
import java.util.Set;

public final class Board extends Prototype { // Prototype inhertitance allowing to copy
    private String name;
    private Set<TasksList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public void setName(String name) { // setter to allow changing name after cloning
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<TasksList> getLists() {
        return lists;
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "]\n";
        for(TasksList list : lists) {
            s = s + list.toString() + "\n";
        }
        return s;
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return (Board)super.clone();
    }
    /***
     * WADA PŁYTKIEGO KLONOWANIA: Co więc dzieje się podczas klonowania obiektu klasy Board? Sklonowaniu ulega również właściwość lists, czyli do nowego obiektu klasy Board,
     * do właściwości lists, zostanie wpisana taka sama wartość, jaka była w oryginalnym obiekcie, a więc referencja do tego samego obiektu HashSet w pamięci komputera.
     * Oznacza to, że gdybyśmy np. chcieli dodać jakiś obiekt do tej listy, zostałby on dodany także w oryginalnej klasie Board i w każdej z jej kopii,
     * ponieważ wszystkie z tych kopii korzystałyby z tego samego obiektu listy (ze swojego prototypu).
     */

    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = (Board)super.clone();
        clonedBoard.lists = new HashSet<>();
        for(TasksList theList : lists) { // po "płytkim" sklonowaniu tworzy nowy obiekt HashSet, a następnie w pętli — dla każdej listy zadań — wykonuje kolejną pętlę, dla każdego zadania na liście. Dla każdego zadania tworzony jest nowy obiekt typu Task, a dla każdej listy zadań tworzona jest nowa lista typu TasksList i cała struktura klonowana jest zadanie po zadaniu do nowych obiektów
            TasksList clonedList = new TasksList(theList.getName());
            for(Task task : theList.getTasks()) {
                clonedList.getTasks().add(task);
            }
            clonedBoard.getLists().add(clonedList);
        }
        return clonedBoard;
    }
}
