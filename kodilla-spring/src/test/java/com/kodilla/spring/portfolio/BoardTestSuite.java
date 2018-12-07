package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {
    ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
    Board board = context.getBean(Board.class);

    @Test
    public void addAndCheckToDoTaskList() {
        //When
        board.getToDoList().addTask("Zrobić zakupy");

        //Then
        board.getToDoList().displayList();
    }

    @Test
    public void addAndCheckInProgressTaskList() {
        //When
        board.getInProgressList().addTask("Ugotować obiad");

        //Then
        board.getInProgressList().displayList();
    }

    @Test
    public void addAndCheckDoneTaskList() {
        //When
        board.getDoneList().addTask("Wyprowadzić psa");

        //Then
        board.getDoneList().displayList();
    }
}
