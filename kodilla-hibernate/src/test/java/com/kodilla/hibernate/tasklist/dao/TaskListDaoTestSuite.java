package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.tasklist.TaskListDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Before
    public void createEntityForTest() {
        TaskList testTaskList = new TaskList("Test List", "List for testing purpose");
        taskListDao.save(testTaskList);
    }

    @After
    public void clearDatabaseAfterTest() {
        taskListDao.deleteAll();
    }

    @Test
    public void testGettingListByName() {
        //when
        List<TaskList> testList = taskListDao.findByListName("Test List");

        //then
        Assert.assertEquals(1, testList.size());
    }
}
