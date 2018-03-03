package com.kodilla.testing.forum.statistics;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsProcessorTestSuite {
    private static int counter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        counter++;
        System.out.println("Preparing to execute test #" + counter);
    }

    @Test
    public void postsNumberEqualToZeroTest(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> usersName = new ArrayList<>();
        usersName.add("Alan");
        usersName.add("Iwona");
        when(statisticsMock.usersNames()).thenReturn(usersName);

        int postCount = 0;
        when(statisticsMock.postsCount()).thenReturn(postCount);

        int commentsCount = 200;
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);

        StatisticsProcessor processor = new StatisticsProcessor();

        //When
        ArrayList result = processor.calculateAdvStatistics(statisticsMock);
        //processor.showStatistics();

        //Then
        assertEquals(true, result.isEmpty());
    }

    @Test
    public void postsNumberEqualTo1000Test() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> userName = new ArrayList<>();
        userName.add("Alan");
        userName.add("Iwona");
        when(statisticsMock.usersNames()).thenReturn(userName);

        int postCount = 1000;
        when(statisticsMock.postsCount()).thenReturn(postCount);

        int commentsCount = 2000;
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);

        StatisticsProcessor processor = new StatisticsProcessor();

        //When
        ArrayList result = processor.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(result.get(3), 500.0);
    }

    @Test
    public void commentsNumberEqualToZeroTest(){
        Statistics statisticsMock = mock(Statistics.class);

        List<String> userName = new ArrayList<>();
        userName.add("Alan");
        userName.add("Iwona");
        when(statisticsMock.usersNames()).thenReturn(userName);

        int postCount = 1000;
        when(statisticsMock.postsCount()).thenReturn(postCount);

        int commentsCount = 0;
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);

        StatisticsProcessor processor = new StatisticsProcessor();

        //When
        ArrayList result = processor.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(true, result.isEmpty());
    }

    @Test
    public void lessCommentsThanPostsTest() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> userName = new ArrayList<>();
        userName.add("Alan");
        userName.add("Iwona");
        when(statisticsMock.usersNames()).thenReturn(userName);

        int postCount = 2;
        when(statisticsMock.postsCount()).thenReturn(postCount);

        int commentsCount = 1;
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);

        StatisticsProcessor processor = new StatisticsProcessor();

        //When
        ArrayList result = processor.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(result.get(5), 0.5);
    }

    @Test
    public void moreCommentsThanPostsTest() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> userName = new ArrayList<>();
        userName.add("Alan");
        userName.add("Iwona");
        when(statisticsMock.usersNames()).thenReturn(userName);

        int postCount = 1;
        when(statisticsMock.postsCount()).thenReturn(postCount);

        int commentsCount = 2;
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);

        StatisticsProcessor processor = new StatisticsProcessor();

        //When
        ArrayList result = processor.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(result.get(5), 2.0);
    }

    @Test
    public void usersNumberEqualToZeroTest(){
        Statistics statisticsMock = mock(Statistics.class);

        List<String> userName = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(userName);

        int postCount = 1000;
        when(statisticsMock.postsCount()).thenReturn(postCount);

        int commentsCount = 0;
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);

        StatisticsProcessor processor = new StatisticsProcessor();

        //When
        ArrayList result = processor.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(true, result.isEmpty());
    }

    @Test
    public void usersNumberEqualTo100Test() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> userName = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            userName.add("Alan" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(userName);

        int postCount = 2;
        when(statisticsMock.postsCount()).thenReturn(postCount);

        int commentsCount = 2;
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);

        StatisticsProcessor processor = new StatisticsProcessor();

        //When
        ArrayList result = processor.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(result.get(2), (double)userName.size());
    }

}
