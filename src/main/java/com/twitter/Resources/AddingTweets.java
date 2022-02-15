package com.twitter.Resources;

import com.twitter.Services.TwitterConnecter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;


public class AddingTweets {
    public String addingTweet(String args) {
        Logger logger = LoggerFactory.getLogger(AddingTweets.class);
        try{
            ApplicationContext applicationContext= new ClassPathXmlApplicationContext("beans.xml");
            TwitterConnecter twitterConnecter= applicationContext.getBean("twitterConnector", TwitterConnecter.class);
            Twitter twitter = twitterConnecter.connectToTwitter();
            Status status = twitter.updateStatus(args);
            String str = status.getText();
            return str;
        } catch (TwitterException e) {
           logger.error("check the yml file for the keys");
            return "Check your access tokens";
        }

    }
}
