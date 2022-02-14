package com.twitter.Resources;

import com.twitter.Services.TwitterConnecter;
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
            TwitterConnecter twitterConnecter= new TwitterConnecter();
            Twitter twitter = twitterConnecter.connectToTwitter();

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
