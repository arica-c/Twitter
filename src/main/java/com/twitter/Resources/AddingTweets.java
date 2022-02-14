package com.twitter.Resources;

import com.twitter.Services.TwitterConnecter;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AddingTweets {
    public String addingTweet(String args) {
        try{
            TwitterConnecter twitterConnecter= new TwitterConnecter();
            Twitter twitter = twitterConnecter.connectToTwitter();


            Status status = twitter.updateStatus(args);
            String str = status.getText();
            return str;
        } catch (TwitterException e) {

            return "Check your access tokens";
        }

    }
}
