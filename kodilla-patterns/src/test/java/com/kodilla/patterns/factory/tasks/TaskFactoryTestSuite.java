package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    private TaskFactory taskFactory = new TaskFactory();

    @Test
    public void testCreateShoppingTask() {
        //given
        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPING);

        //when
        String expectedName = "Buy";
        shoppingTask.executeTask();
        String realName = shoppingTask.getTaskName();

        //then
        Assert.assertTrue(expectedName.equals(realName));
        Assert.assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    public void testCreatePaintingTask() {
        //given
        Task paintingTask = taskFactory.makeTask(TaskFactory.PAINTING);

        //when
        String expectedName = "Paint";
        paintingTask.executeTask();
        String realName = paintingTask.getTaskName();

        //then
        Assert.assertTrue(expectedName.equals(realName));
        Assert.assertTrue(paintingTask.isTaskExecuted());

    }

    @Test
    public void testCreateDrivingTask() {
        //given
        Task drivingTask = taskFactory.makeTask(TaskFactory.DRIVING);

        //when
        String expectedName = "Drive";
        drivingTask.executeTask();
        String realName = drivingTask.getTaskName();

        //then
        Assert.assertTrue(expectedName.equals(realName));
        Assert.assertTrue(drivingTask.isTaskExecuted());

    }
}
