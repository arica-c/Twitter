package com.twitter.starter;

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
            YMLConfig ymlConfig= new YMLConfig();

            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true).setOAuthConsumerKey(ymlConfig.getConsumerKey())
                    .setOAuthConsumerSecret(ymlConfig.getConsumerSecret())
                    .setOAuthAccessToken(ymlConfig.getAccessToken())
                    .setOAuthAccessTokenSecret(ymlConfig.getTokenSecret());
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();


            Status status = twitter.updateStatus(args);
            String str = status.getText();
            return str;
        } catch (TwitterException e) {

            return "Check your access tokens";
        }

    }
}
