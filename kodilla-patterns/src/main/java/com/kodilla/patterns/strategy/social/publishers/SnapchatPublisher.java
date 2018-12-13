package com.kodilla.patterns.strategy.social.publishers;

public class SnapchatPublisher implements Publisher {
    @Override
    public String share(String message) {
        return "[Publishing on Snapchat] " + message;
    }
}
