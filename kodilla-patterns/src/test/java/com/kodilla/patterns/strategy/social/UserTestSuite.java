package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    private Millenials millenialUser = new Millenials("Maciek");
    private YGeneration yGenerationUser = new YGeneration("Marek");
    private ZGeneration zGenerationUser = new ZGeneration("Mateusz");

    @Test
    public void testDefaultMillenialPublishing() {
        //when
        String expectedMessage = "[Publishing on Facebook] testMessage";
        String realMessage = millenialUser.sharePost("testMessage");

        //then
        Assert.assertTrue(expectedMessage.equals(realMessage));

    }

    @Test
    public void testDefaultYGenerationPublishing() {
        //when
        String expectedMessage = "[Publishing on Twitter] testMessage";
        String realMessage = yGenerationUser.sharePost("testMessage");

        //then
        Assert.assertTrue(expectedMessage.equals(realMessage));

    }

    @Test
    public void testDefaultZGenerationPublishing() {
        //when
        String expectedMessage = "[Publishing on Snapchat] testMessage";
        String realMessage = zGenerationUser.sharePost("testMessage");

        //then
        Assert.assertTrue(expectedMessage.equals(realMessage));

    }

    @Test
    public void testIndividualPublishing() {
        //given
        YGeneration individualYGenerationUser = new YGeneration("Renegade");
        individualYGenerationUser.setSocialMediaPublisher(new FacebookPublisher());

        //when
        String expectedMessage = "[Publishing on Facebook] testMessage";
        String realMessage = individualYGenerationUser.sharePost("testMessage");

        //then
        Assert.assertTrue(expectedMessage.equals(realMessage));

    }
}
