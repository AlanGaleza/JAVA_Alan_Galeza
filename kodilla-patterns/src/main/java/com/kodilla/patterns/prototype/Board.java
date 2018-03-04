package com.kodilla.patterns.prototype;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class Board extends Prototype<Board> {
    String name;
    Set<TasksList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<TasksList> getLists() {
        return lists;
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "]\n";
        for(TasksList list : lists) {
            s = s + list.toString() + "\n";
        }
        return s;
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

//mozna tak lub streamem(lambda) nizej
/*    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = super.clone();
        clonedBoard.lists = new HashSet<>();
        for(TasksList theList : lists) {
            TasksList clonedList = new TasksList(theList.getName());
            for(Task task : theList.getTasks()) {
                clonedList.getTasks().add(task);
            }
            clonedBoard.getLists().add(clonedList);
        }
        return clonedBoard;
    }*/

    public Board deepCopy1() throws CloneNotSupportedException {
        Board clonedBoard = super.clone();
        clonedBoard.lists = lists.stream().map(tasksList -> new TasksList(tasksList.getName(), tasksList.getTasks().stream().map(task -> new Task(task.getName())).collect(Collectors.toList()))).collect(Collectors.toSet());
        return clonedBoard;
    }
}