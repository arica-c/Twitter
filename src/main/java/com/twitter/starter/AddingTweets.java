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
        try {
            Properties prop = new Properties();
            String propFileName = "application.properties";

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            //Getting the properties from file
            String consmerKey = prop.getProperty("consumerKey");
            String consumerSecret = prop.getProperty("consumerSecret");
            String accessToken = prop.getProperty("accessToken");
            String tokenSecret = prop.getProperty("tokenSecret");

            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true).setOAuthConsumerKey(consmerKey)
                    .setOAuthConsumerSecret(consumerSecret)
                    .setOAuthAccessToken(accessToken)
                    .setOAuthAccessTokenSecret(tokenSecret);
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();


            Status status = twitter.updateStatus(args);
            String str = status.getText();
            return str;
        } catch (TwitterException e) {

            return "Check your access tokens";
        }
        catch(IOException e){
            return "Exception raised while reading the application file";
        }
    }
}
