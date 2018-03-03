package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> theForumUserList = new ArrayList<>();

    public Forum () {
        theForumUserList.add(new ForumUser(1, "Gabriela", ForumUser.Gender.F, LocalDate.of(1990,12,20), 100));
        theForumUserList.add(new ForumUser(2, "Iwona", ForumUser.Gender.F, LocalDate.of(2000,11,01), 0));
        theForumUserList.add(new ForumUser(3, "Alan", ForumUser.Gender.M, LocalDate.of(1990,10,02), 1000));
     }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theForumUserList);
    }
}
