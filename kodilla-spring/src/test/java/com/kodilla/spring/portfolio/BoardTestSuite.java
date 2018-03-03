package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.*;

public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.getToDoList().getTasks().add("This is ToDoList");
        board.getInProgressList().getTasks().add("This is InProgressList");
        board.getDoneList().getTasks().add("This is Done List");

        String toDoListResult = board.getToDoList().getTasks().get(0);
        String inProgressListResult = board.getInProgressList().getTasks().get(0);
        String doneListResult = board.getDoneList().getTasks().get(0);

        //Then
        assertThat(toDoListResult).isEqualTo("This is ToDoList");
        assertThat(inProgressListResult).isEqualTo("This is InProgressList");
        assertThat(doneListResult).isEqualTo("This is Done List");


    }
}
