package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Tasks {
    private final String taskName;
    private final String wahtToBut;
    private final double quantity;
    private static boolean taskStatus = false;

    public ShoppingTask(String taskName, String wahtToBut, double quantity) {
        this.taskName = taskName;
        this.wahtToBut = wahtToBut;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        taskStatus = true;
        System.out.println("ShoppingTask has been executed.");
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
