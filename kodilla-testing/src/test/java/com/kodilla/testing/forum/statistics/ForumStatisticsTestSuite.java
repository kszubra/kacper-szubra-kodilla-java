package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.statistics.Statistics;
import com.kodilla.testing.forum.statistics.StatisticsCalculator;
import org.junit.*;
import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    StatisticsCalculator testStatisticCalculator = new StatisticsCalculator();

    @BeforeClass
    public static void announceStart(){
        System.out.println("Tests starting:");
    }

    @AfterClass
    public static void announceEnd(){
        System.out.println("Tests finished");
    }

    @Before
    public void beforeTest(){
        System.out.print("New case: ");
    }

    @After
    public void afterTest(){
        System.out.println("Case tested");
    }

    @Test
    public void testCalculateAdvStatistics0Posts(){
        System.out.println("0 posts, 1000 users, 0 comments");
        //Given
        Statistics mockedStatistics = mock(Statistics.class);
        List<String> usernameList = new ArrayList<String>();
        for (int i = 0; i<1000; i++){
            usernameList.add("test");
        }
        when(mockedStatistics.commentsCount()).thenReturn(0);
        when(mockedStatistics.postsCount()).thenReturn(0);
        when(mockedStatistics.usersNames()).thenReturn(usernameList);
        testStatisticCalculator.calculateAdvStatistics(mockedStatistics);
        //When
        double expectedNumberOfUsers = 1000.0;
        double expectedNumberOfPosts = 0.0;
        double expectedNumberOfComments = 0.0;
        double expectedAveragePostsPerUser = 0.0;
        double expectedAverageCommentsPerUser = 0.0;
        double expectedAverageCommentsPerPost = 0.0;
        //Then
        Assert.assertEquals(expectedNumberOfUsers, testStatisticCalculator.getNumberOfUsers(),0);
        Assert.assertEquals(expectedNumberOfPosts, testStatisticCalculator.getNumberOfPosts(),0);
        Assert.assertEquals(expectedNumberOfComments, testStatisticCalculator.getNumberOfComments(),0);
        Assert.assertEquals(expectedAveragePostsPerUser, testStatisticCalculator.getAveragePostsPerUser(),0);
        Assert.assertEquals(expectedAverageCommentsPerUser, testStatisticCalculator.getAverageCommentsPerUser(),0);
        Assert.assertEquals(expectedAverageCommentsPerPost, testStatisticCalculator.getAverageCommentsPerPost(),0);
    }

    @Test
    public void testCalculateAdvStatistics100Posts(){
        System.out.println("1000 posts, 1000 users, 0 comments");
        //Given
        Statistics mockedStatistics = mock(Statistics.class);
        List<String> usernameList = new ArrayList<String>();
        for (int i = 0; i<1000; i++){
            usernameList.add("test");
        }
        when(mockedStatistics.commentsCount()).thenReturn(0);
        when(mockedStatistics.postsCount()).thenReturn(1000);
        when(mockedStatistics.usersNames()).thenReturn(usernameList);
        testStatisticCalculator.calculateAdvStatistics(mockedStatistics);
        //When
        double expectedNumberOfUsers = 1000.0;
        double expectedNumberOfPosts = 1000.0;
        double expectedNumberOfComments = 0.0;
        double expectedAveragePostsPerUser = 1.0;
        double expectedAverageCommentsPerUser = 0.0;
        double expectedAverageCommentsPerPost = 0.0;
        //Then
        Assert.assertEquals(expectedNumberOfUsers, testStatisticCalculator.getNumberOfUsers(),0);
        Assert.assertEquals(expectedNumberOfPosts, testStatisticCalculator.getNumberOfPosts(),0);
        Assert.assertEquals(expectedNumberOfComments, testStatisticCalculator.getNumberOfComments(),0);
        Assert.assertEquals(expectedAveragePostsPerUser, testStatisticCalculator.getAveragePostsPerUser(),0);
        Assert.assertEquals(expectedAverageCommentsPerUser, testStatisticCalculator.getAverageCommentsPerUser(),0);
        Assert.assertEquals(expectedAverageCommentsPerPost, testStatisticCalculator.getAverageCommentsPerPost(),0);
    }

    @Test
    public void testCalculateAdvStatistics0Users(){
        System.out.println("0 posts, 0 users, 0 comments");
        //Given
        Statistics mockedStatistics = mock(Statistics.class);
        List<String> usernameList = new ArrayList<String>();
        when(mockedStatistics.commentsCount()).thenReturn(0);
        when(mockedStatistics.postsCount()).thenReturn(0);
        when(mockedStatistics.usersNames()).thenReturn(usernameList);
        testStatisticCalculator.calculateAdvStatistics(mockedStatistics);
        //When
        double expectedNumberOfUsers = 0.0;
        double expectedNumberOfPosts = 0.0;
        double expectedNumberOfComments = 0.0;
        double expectedAveragePostsPerUser = 0.0;
        double expectedAverageCommentsPerUser = 0.0;
        double expectedAverageCommentsPerPost = 0.0;
        //Then
        Assert.assertEquals(expectedNumberOfUsers, testStatisticCalculator.getNumberOfUsers(),0);
        Assert.assertEquals(expectedNumberOfPosts, testStatisticCalculator.getNumberOfPosts(),0);
        Assert.assertEquals(expectedNumberOfComments, testStatisticCalculator.getNumberOfComments(),0);
        Assert.assertEquals(expectedAveragePostsPerUser, testStatisticCalculator.getAveragePostsPerUser(),0);
        Assert.assertEquals(expectedAverageCommentsPerUser, testStatisticCalculator.getAverageCommentsPerUser(),0);
        Assert.assertEquals(expectedAverageCommentsPerPost, testStatisticCalculator.getAverageCommentsPerPost(),0);
    }

    @Test
    public void testCalculateAdvStatisticsLessCommentsThanPosts(){
        System.out.println("1000 posts, 2000 users, 500 comments");
        //Given
        Statistics mockedStatistics = mock(Statistics.class);
        List<String> usernameList = new ArrayList<String>();
        for (int i = 0; i<2000.0; i++){
            usernameList.add("test");
        }
        when(mockedStatistics.commentsCount()).thenReturn(500);
        when(mockedStatistics.postsCount()).thenReturn(1000);
        when(mockedStatistics.usersNames()).thenReturn(usernameList);
        testStatisticCalculator.calculateAdvStatistics(mockedStatistics);
        //When
        double expectedNumberOfUsers = 2000.0;
        double expectedNumberOfPosts = 1000.0;
        double expectedNumberOfComments = 500.0;
        double expectedAveragePostsPerUser = 0.5;
        double expectedAverageCommentsPerUser = 0.25;
        double expectedAverageCommentsPerPost = 0.5;
        //Then
        Assert.assertEquals(expectedNumberOfUsers, testStatisticCalculator.getNumberOfUsers(),0);
        Assert.assertEquals(expectedNumberOfPosts, testStatisticCalculator.getNumberOfPosts(),0);
        Assert.assertEquals(expectedNumberOfComments, testStatisticCalculator.getNumberOfComments(),0);
        Assert.assertEquals(expectedAveragePostsPerUser, testStatisticCalculator.getAveragePostsPerUser(),0);
        Assert.assertEquals(expectedAverageCommentsPerUser, testStatisticCalculator.getAverageCommentsPerUser(),0);
        Assert.assertEquals(expectedAverageCommentsPerPost, testStatisticCalculator.getAverageCommentsPerPost(),0);
    }

    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts(){
        System.out.println("500 posts, 2000 users, 1000 comments");
        //Given
        Statistics mockedStatistics = mock(Statistics.class);
        List<String> usernameList = new ArrayList<String>();
        for (int i = 0; i<2000.0; i++){
            usernameList.add("test");
        }
        when(mockedStatistics.commentsCount()).thenReturn(1000);
        when(mockedStatistics.postsCount()).thenReturn(500);
        when(mockedStatistics.usersNames()).thenReturn(usernameList);
        testStatisticCalculator.calculateAdvStatistics(mockedStatistics);
        //When
        double expectedNumberOfUsers = 2000.0;
        double expectedNumberOfPosts = 500.0;
        double expectedNumberOfComments = 1000.0;
        double expectedAveragePostsPerUser = 0.25;
        double expectedAverageCommentsPerUser = 0.5;
        double expectedAverageCommentsPerPost = 2.0;
        //Then
        Assert.assertEquals(expectedNumberOfUsers, testStatisticCalculator.getNumberOfUsers(),0);
        Assert.assertEquals(expectedNumberOfPosts, testStatisticCalculator.getNumberOfPosts(),0);
        Assert.assertEquals(expectedNumberOfComments, testStatisticCalculator.getNumberOfComments(),0);
        Assert.assertEquals(expectedAveragePostsPerUser, testStatisticCalculator.getAveragePostsPerUser(),0);
        Assert.assertEquals(expectedAverageCommentsPerUser, testStatisticCalculator.getAverageCommentsPerUser(),0);
        Assert.assertEquals(expectedAverageCommentsPerPost, testStatisticCalculator.getAverageCommentsPerPost(),0);
    }


}
