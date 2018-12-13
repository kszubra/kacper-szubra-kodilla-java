package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.Publisher;

public abstract class User {
    private String username;
    protected Publisher socialMediaPublisher;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setSocialMediaPublisher(Publisher socialMediaPublisher) {
        this.socialMediaPublisher = socialMediaPublisher;
    }

    public String sharePost(String message) {
        return socialMediaPublisher.share(message);
    }
}
