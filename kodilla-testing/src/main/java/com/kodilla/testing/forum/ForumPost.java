package com.kodilla.testing.forum;

import java.util.Objects;

public class ForumPost {
    private String postBody;
    private String author;

    public ForumPost(String postBody, String author) {
        this.postBody = postBody;
        this.author = author;
    }

    public String getPostBody() {
        return postBody;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumPost)) return false;
        ForumPost forumPost = (ForumPost) o;
        return Objects.equals(getPostBody(), forumPost.getPostBody()) &&
                Objects.equals(getAuthor(), forumPost.getAuthor());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPostBody(), getAuthor());
    }
}
