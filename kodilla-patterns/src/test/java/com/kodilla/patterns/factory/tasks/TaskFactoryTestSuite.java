package com.kodilla.patterns.factory.tasks;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    public void ShoppingTaskTest () {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Tasks shoppingTask = factory.taskCreator(TaskFactory.SHOPPINGTASK);
        shoppingTask.executeTask();
        //Then
        assertThat(shoppingTask.getTaskName()).isEqualTo("ShoppingTask");
        assertThat(shoppingTask.isTaskExecuted()).isTrue();
    }

    @Test
    public void PaintingTaskTest () {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Tasks paintingTask = factory.taskCreator(TaskFactory.PAINTINGTASK);
        paintingTask.executeTask();
        //Then
        assertThat(paintingTask.getTaskName()).isEqualTo("PaintingTask");
        assertThat(paintingTask.isTaskExecuted()).isTrue();
    }

    @Test
    public void DrivingTaskTest () {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Tasks drivingTask = factory.taskCreator(TaskFactory.DRIVINGTASK);
        drivingTask.executeTask();
        //Then
        assertThat(drivingTask.getTaskName()).isEqualTo("DrivingTask");
        assertThat(drivingTask.isTaskExecuted()).isTrue();
    }

}
