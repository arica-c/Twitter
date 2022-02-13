package com.twitter;

import com.twitter.controller.TwitterRestController;

import com.twitter.starter.TwitterApplication;
import org.junit.Assert;
import org.junit.Test;
import twitter4j.TwitterException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TwitterRestControllerTest {
    @Test
    public void TweetTest() throws TwitterException, IOException {
       TwitterRestController twitterTest= new TwitterRestController();
       assertEquals("Good Morning", twitterTest.addingTweet("Good Morning"));
        List<List<String>> list=  twitterTest.getTimeline();
        assertTrue(list instanceof ArrayList);
    }

    @Test
    public void applicationTest() {
        TwitterApplication.main(new String[] {});
    }


}
