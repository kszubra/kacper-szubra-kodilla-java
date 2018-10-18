package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        Forum exampleForum = new Forum();
        Map<Integer, ForumUser> resultForumUsersMap = exampleForum.getForumUsersList().stream()
                .filter(n -> n.getSex() == 'M')
                .filter(n -> (Period.between(n.getBirthday(), LocalDate.now())).getYears()> 19)
                .filter(n -> n.getPostsNumber() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, n->n));

        resultForumUsersMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

    }
}
