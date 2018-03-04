package com.kodilla.patterns.prototype;

import java.util.ArrayList;
import java.util.List;

public final class TasksList {
    final String name;
    private List<Task> tasks;

    public TasksList(final String name, final List<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String s = "   List [" + name + "]";
        for(Task task : tasks) {
            s = s + "\n" + task.toString();
        }
        return s;
    }
}