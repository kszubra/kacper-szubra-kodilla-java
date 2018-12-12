package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoggerTestSuite {

    @Before
    public void createTestLogMessage() {
        Logger.getInstance().log("Adding a log before test");
    }

    @Test
    public void testGettingLastLog() {
        //When
        String expectedLog = "Adding a log before test";
        String realLog = Logger.getInstance().getLastLog();

        //Then
        Assert.assertEquals(expectedLog, realLog);
    }
}
