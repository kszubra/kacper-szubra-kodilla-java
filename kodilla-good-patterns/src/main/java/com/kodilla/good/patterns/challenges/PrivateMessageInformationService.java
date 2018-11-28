package com.kodilla.good.patterns.challenges;

public class PrivateMessageInformationService implements UserInformationService {

    @Override
    public void informUser(User user, String message) {
        System.out.println("Sending private message to " + user.getUsername() + ": " + message);
    }
}
