package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int uniqueId;
    private final String userName;
    public  enum Gender {M, F}
    private final Gender gender;
    private final LocalDate birthDate;
    private final int numberOfPosts;

    public ForumUser(final int uniqueId, final String userName, final Gender gender, final LocalDate birthDate, final int numberOfPosts) {
        this.uniqueId = uniqueId;
        this.userName = userName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.numberOfPosts = numberOfPosts;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public String getUserName() {
        return userName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }


    @Override
    public String toString() {
        return "ForumUser{" +
                "uniqueId=" + uniqueId +
                ", userName='" + userName + '\'' +
                ", birthDate=" + birthDate +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
}
