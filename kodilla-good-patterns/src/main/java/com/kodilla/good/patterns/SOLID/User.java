package com.kodilla.good.patterns.SOLID;

public class User {

    private final String name;
    private final String Surname;

    public String getSurname() {
        return Surname;
    }

    public String getName() {

        return name;
    }

    public User(String name, String surname) {

        this.name = name;
        Surname = surname;
    }
}
