package com.twitter.Resources;

import com.twitter.Services.TwitterConnecter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class FilterTimeline {
    public static List<String> searchtweets(String filter)  {

        try{
            ApplicationContext applicationContext= new ClassPathXmlApplicationContext("beans.xml");
            TwitterConnecter twitterConnecter= applicationContext.getBean("twitterConnector", TwitterConnecter.class);
            Twitter twitter = twitterConnecter.connectToTwitter();
            return twitter.getUserTimeline().stream()
                    .map(item -> item.getText()).filter(item -> item.contains(filter)).collect(Collectors.toList());
        } catch (TwitterException e) {

            return Collections.singletonList( "Check your access tokens");
        }





    }
}

