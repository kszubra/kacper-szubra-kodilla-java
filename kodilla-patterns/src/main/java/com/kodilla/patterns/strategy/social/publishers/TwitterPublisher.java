package com.kodilla.patterns.strategy.social.publishers;

public class TwitterPublisher implements Publisher {
    @Override
    public String share(String message) {
        return "[Publishing on Twitter] " + message;
    }
}
