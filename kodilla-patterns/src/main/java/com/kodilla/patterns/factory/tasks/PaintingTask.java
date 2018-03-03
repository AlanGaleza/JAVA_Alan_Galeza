package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Tasks {
    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private static boolean taskStatus = false;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        taskStatus = true;
        System.out.println("PaintingTask has been executed.");
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskStatus;
    }
}
