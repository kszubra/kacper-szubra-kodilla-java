package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int userId;
    private final String username;
    private final char sex;
    private final LocalDate birthday;
    private final int postsNumber;

    public ForumUser(int userId, String username, char sex, LocalDate birthday, int postsNumber) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.postsNumber = postsNumber;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", postsNumber=" + postsNumber +
                '}';
    }
}
