package com.kodilla.good.patterns.challenges.three.user.information.services;

import com.kodilla.good.patterns.challenges.three.User;

public class TextMessageInformationService implements InformWebsiteUserService {
    @Override
    public void informUser(User user, String message) {
        System.out.println("Sending message: " + message + " to user: " +user.getUsername() + " by text message on their mobile");
    }
}
