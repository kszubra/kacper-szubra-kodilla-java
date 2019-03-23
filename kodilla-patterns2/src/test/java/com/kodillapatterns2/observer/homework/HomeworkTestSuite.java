package com.kodillapatterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

public class HomeworkTestSuite {
    @Test
    public void testUpdatingMentors() {
        //Given
        HomeworkQueue johnRamboHomeworkQueue = new HomeworkQueue(new Student("John Rambo"));
        HomeworkQueue jackSparrowHomeworkQueue = new HomeworkQueue(new Student("Jack Sparrow"));
        HomeworkQueue darthVaderHomeworkQueue = new HomeworkQueue(new Student("Darth Vader"));

        Mentor imperator = new Mentor("Darth Sidious");
        Mentor paiMei = new Mentor("Pai Mei");

        darthVaderHomeworkQueue.registerObserver(imperator);
        johnRamboHomeworkQueue.registerObserver(paiMei);
        jackSparrowHomeworkQueue.registerObserver(paiMei);

        //When
        johnRamboHomeworkQueue.addHomework(new Homework("Avoiding first blood", "test description"));
        jackSparrowHomeworkQueue.addHomework(new Homework("Drunk sailing", "test description"));
        jackSparrowHomeworkQueue.addHomework(new Homework("Not getting face slapped in brothel", "test description"));
        darthVaderHomeworkQueue.addHomework(new Homework("Finding lack of faith not disturbing", "test description"));
        darthVaderHomeworkQueue.addHomework(new Homework("Getting the High Grounds", "test description"));

        //Then
        Assert.assertEquals(2, imperator.getUpdateCount());
        Assert.assertEquals(3, paiMei.getUpdateCount());

    }
}
