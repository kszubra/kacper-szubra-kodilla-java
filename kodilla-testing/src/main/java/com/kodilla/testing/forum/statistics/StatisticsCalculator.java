package com.kodilla.testing.forum.statistics;

import java.util.*;

public class StatisticsCalculator {

    private double numberOfUsers;
    private double numberOfPosts;
    private double numberOfComments;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;
    private List<Double> allStatistics;

    public void calculateAdvStatistics(Statistics statistics){
        this.numberOfUsers = (double)statistics.usersNames().size();
        this.numberOfPosts = (double)statistics.postsCount();
        this.numberOfComments = (double)statistics.commentsCount();

        if(numberOfUsers==0){
            this.averagePostsPerUser = 0;
            this.averageCommentsPerUser = 0;
        } else {
            this.averagePostsPerUser = numberOfPosts / numberOfUsers;
            this.averageCommentsPerUser = numberOfComments / numberOfUsers;
        }

        if(numberOfPosts == 0){
            this.averageCommentsPerPost = 0;
        } else{
            this.averageCommentsPerPost = numberOfComments / numberOfPosts;
        }

        this.allStatistics = Arrays.asList((double)numberOfUsers, (double)numberOfPosts, (double)numberOfComments, averagePostsPerUser, averageCommentsPerUser, averageCommentsPerPost);
    }


    public List<Double> getResults(){
        return allStatistics;
    }
}
