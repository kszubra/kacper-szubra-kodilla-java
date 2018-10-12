package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.statistics.Statistics;
import com.kodilla.testing.forum.statistics.StatisticsCalculator;
import org.junit.*;
import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    public List<String> usernameList;
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
        List<Double> result = testStatisticCalculator.getResults();
        List<Double> expectedResult = Arrays.asList(1000.0,0.0,0.0,0.0,0.0,0.0); //{users, posts, comments, post/person, comment/person, comment/post}
        //Then
        Assert.assertEquals(expectedResult, result);
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
        List<Double> result = testStatisticCalculator.getResults();
        List<Double> expectedResult = Arrays.asList(1000.0,1000.0,0.0,1.0,0.0,0.0); //{users, posts, comments, post/person, comment/person, comment/post}
        //Then
        Assert.assertEquals(expectedResult, result);
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
        List<Double> result = testStatisticCalculator.getResults();
        List<Double> expectedResult = Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0); //{users, posts, comments, post/person, comment/person, comment/post}
        //Then
        Assert.assertEquals(expectedResult, result);
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
        List<Double> result = testStatisticCalculator.getResults();
        List<Double> expectedResult = Arrays.asList(2000.0,1000.0,500.0,0.5,0.25,0.5); //{users, posts, comments, post/person, comment/person, comment/post}
        //Then
        Assert.assertEquals(expectedResult, result);
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
        List<Double> result = testStatisticCalculator.getResults();
        List<Double> expectedResult = Arrays.asList(2000.0,500.0,1000.0,0.25,0.5,2.0); //{users, posts, comments, post/person, comment/person, comment/post}
        //Then
        Assert.assertEquals(expectedResult, result);
    }


}
