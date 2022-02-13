package com.twitter.starter;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class GettingTimeline {
    public List<String> getTimeline(){
        try{
                YMLConfig ymlConfig= new YMLConfig();

                ConfigurationBuilder cb = new ConfigurationBuilder();
                cb.setDebugEnabled(true).setOAuthConsumerKey(ymlConfig.getConsumerKey())
                        .setOAuthConsumerSecret(ymlConfig.getConsumerSecret())
                        .setOAuthAccessToken(ymlConfig.getAccessToken())
                        .setOAuthAccessTokenSecret(ymlConfig.getTokenSecret());
                TwitterFactory tf = new TwitterFactory(cb.build());
                Twitter twitter = tf.getInstance();


                List<String> list = twitter.getHomeTimeline().stream()
                    .map(item -> item.getText())
                    .collect(Collectors.toList());
            return list;

        }
        catch(TwitterException e){
            return Collections.singletonList("Check your access tokens");
        }

    }
}
