package com.twitter.Resources;

import com.twitter.Services.TwitterConnecter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;


public class AddingTweets {
    public String addingTweet(String args) {
        try{
            ApplicationContext applicationContext= new ClassPathXmlApplicationContext("beans.xml");
            TwitterConnecter twitterConnecter= applicationContext.getBean("twitterConnector", TwitterConnecter.class);
            Twitter twitter = twitterConnecter.connectToTwitter();
            Status status = twitter.updateStatus(args);
            String str = status.getText();
            return str;
        } catch (TwitterException e) {

            return "Check your access tokens";
        }

    }
}
