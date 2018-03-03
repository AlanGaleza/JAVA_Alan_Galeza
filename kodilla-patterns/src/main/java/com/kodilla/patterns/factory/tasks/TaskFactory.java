package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public final static String SHOPPINGTASK = "SHOPPINGTASK";
    public final static String PAINTINGTASK = "PAINTINGTASK";
    public final static String DRIVINGTASK = "DRIVINGTASK";

    public final Tasks taskCreator(final String task) {
        switch (task) {
            case SHOPPINGTASK :
                return new ShoppingTask("ShoppingTask", "WhatToBuy", 2);
            case PAINTINGTASK :
                return new PaintingTask("PaintingTask", "Color", "WhatToPaint");
            case DRIVINGTASK :
                return  new DrivingTask("DrivingTask", "Where", "Using");
            default :
                return null;
        }
    }
}
