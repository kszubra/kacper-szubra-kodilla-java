package com.kodilla.patterns.strategy.social.publishers;

public class FacebookPublisher implements Publisher {
    @Override
    public String share(String message) {
        return "[Publishing on Facebook] " + message;
    }
}
