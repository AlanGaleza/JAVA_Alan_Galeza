package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {

    private final String username;

    public ForumUser() {
        username = "John Smith";
    }

    public String getUsername() {
        return username;
    }
}
