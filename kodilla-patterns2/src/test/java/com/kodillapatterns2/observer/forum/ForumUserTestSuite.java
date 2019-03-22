package com.kodillapatterns2.observer.forum;

import org.junit.Assert;
import org.junit.Test;

public class ForumUserTestSuite {

    @Test
    public void testUpdate() {
        //Given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic javaToolsForum = new JavaToolsForumTopic();

        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser johnRambo = new ForumUser("John Rambo");
        ForumUser jackSparrow = new ForumUser("Jack Sparrow");

        javaHelpForum.registerObserver(johnSmith);
        javaHelpForum.registerObserver(johnRambo);
        javaToolsForum.registerObserver(jackSparrow);
        javaToolsForum.registerObserver(johnRambo);

        //When
        javaHelpForum.addPost("1");
        javaHelpForum.addPost("2");
        javaHelpForum.addPost("3");
        javaToolsForum.addPost("4");
        javaToolsForum.addPost("5");

        //Then
        Assert.assertEquals(5, johnRambo.getUpdateCount());
        Assert.assertEquals(3, johnSmith.getUpdateCount());
        Assert.assertEquals(2, jackSparrow.getUpdateCount());
    }
}
