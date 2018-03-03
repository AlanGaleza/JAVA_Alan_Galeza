package com.kodilla.testing.forum.statistics;

import java.util.ArrayList;

public class StatisticsProcessor {
    private Statistics statistics;
    private ArrayList<Double> statisticsArray = new ArrayList<>();

    public ArrayList calculateAdvStatistics(Statistics statistics) {
        this.statistics = statistics;

        double numberOfPosts = statistics.postsCount();
        double numberOfComments = statistics.commentsCount();
        double numberOfUsers = statistics.usersNames().size();

        if (numberOfPosts == 0 || numberOfComments == 0 || numberOfUsers == 0) {
            return new ArrayList();
        }

        double averageNumberOfPostsPerUser = numberOfPosts / numberOfUsers;
        double averageNumberOfCommentsPerUser = numberOfComments / numberOfUsers;
        double averageNumberOfCommentsPerPost = numberOfComments / numberOfPosts;



        statisticsArray.add(numberOfPosts);                         //0
        statisticsArray.add(numberOfComments);                      //1
        statisticsArray.add(numberOfUsers);                         //2
        statisticsArray.add(averageNumberOfPostsPerUser);           //3
        statisticsArray.add(averageNumberOfCommentsPerUser);        //4
        statisticsArray.add(averageNumberOfCommentsPerPost);        //5

        return statisticsArray;
    }

    public void showStatistics () {
        for (int i = 0; i < statisticsArray.size(); i++) {
            System.out.println(statisticsArray.get(i));
        }
     }
}


