package com.twitter.Services;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConnecter {
    public Twitter connectToTwitter(){
        YMLConfig ymlConfig= new YMLConfig();

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey(ymlConfig.getConsumerKey())
                .setOAuthConsumerSecret(ymlConfig.getConsumerSecret())
                .setOAuthAccessToken(ymlConfig.getAccessToken())
                .setOAuthAccessTokenSecret(ymlConfig.getTokenSecret());
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        return twitter;
    }
}
