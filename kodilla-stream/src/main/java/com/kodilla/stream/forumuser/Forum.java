package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> forumUsersList;

    public Forum() {
        this.forumUsersList = new ArrayList<ForumUser>();
        forumUsersList.add(new ForumUser(1,"artur23", 'M', LocalDate.of(1999, 1, 23),0));
        forumUsersList.add(new ForumUser(2,"marysia", 'F', LocalDate.of(2004, 4, 04), 3));
        forumUsersList.add(new ForumUser(3,"robertusar", 'M', LocalDate.of(1977, 8, 13), 45));
        forumUsersList.add(new ForumUser(4,"zenon", 'M', LocalDate.of(1969, 11, 20),92));
        forumUsersList.add(new ForumUser(5,"madzia", 'F', LocalDate.of(2011, 1, 22),0));
        forumUsersList.add(new ForumUser(6,"sławomiro", 'M', LocalDate.of(1957, 5, 15),0));
        forumUsersList.add(new ForumUser(7,"krysia", 'F', LocalDate.of(1949, 6, 19),2));
        forumUsersList.add(new ForumUser(8,"fiona", 'F', LocalDate.of(2010, 01, 23),23));
        forumUsersList.add(new ForumUser(9,"anastazja", 'F', LocalDate.of(2008, 01, 11),56));
    }

    public List<ForumUser> getForumUsersList() {
        return new ArrayList<>(forumUsersList);
    }


}
