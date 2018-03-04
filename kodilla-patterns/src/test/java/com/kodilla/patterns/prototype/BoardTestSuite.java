package com.kodilla.patterns.prototype;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BoardTestSuite {
    @Test
    public void testToString() {
        //given

        List<Task> toDoList = new ArrayList<>();
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> toDoList.add(new Task("To Do Task number " + n)));
        //creating the TasksList for todos
        TasksList listToDo = new TasksList("To Do Tasks", toDoList);

        //creating the TaskList for tasks in progress
        List<Task> inProgressList = new ArrayList<>();
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> inProgressList.add(new Task("In progress Tasks " + n)));
        TasksList listInProgress = new TasksList("In Progress Tasks", inProgressList);

        //creating the TaskList for done tasks
        List<Task> doneList = new ArrayList<>();
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> doneList.add(new Task("Done Task number " + n)));
        TasksList listDone = new TasksList("Done Tasks", doneList);

        //creating the board and assigning the lists
        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);
        System.out.println(board);

        //making a shallow clone of object board
        Board clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of object board
        Board deepClonedBoard = null;
        try {
            deepClonedBoard = board.deepCopy1();
            deepClonedBoard.setName("Project number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        board.getLists().remove(listToDo);

        //Then
        System.out.println(board);
        System.out.println(clonedBoard);
        System.out.println(deepClonedBoard);
        Assert.assertEquals(2, board.getLists().size());
        Assert.assertEquals(2, clonedBoard.getLists().size());
        Assert.assertEquals(3, deepClonedBoard.getLists().size());
        Assert.assertEquals(clonedBoard.getLists(), board.getLists());
        Assert.assertNotEquals(deepClonedBoard.getLists(), board.getLists());

    }
}