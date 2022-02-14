package com.twitter.Resources;

import com.twitter.Services.TwitterConnecter;
import com.twitter.models.TwitterPost;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GettingTimeline {
    public List<List<String>> getTimeline(){
        TwitterConnecter twitterConnecter= new TwitterConnecter();
        Twitter twitter = twitterConnecter.connectToTwitter();
        try {
            List<TwitterPost> list = twitter.getHomeTimeline().stream()
                    .map(item -> {

                        TwitterPost tp = new TwitterPost();
                        tp.setmessage(item.getText());
                        tp.setTwitterHandle(item.getUser().getName());
                        tp.setProfileImageURL(item.getUser().getProfileImageURL());
                        tp.setCreatedAt(item.getCreatedAt().toString());
                        return tp;
                    })
                    .collect(Collectors.toList());


            List<List<String>> twitterPost = new ArrayList<>();
            for (TwitterPost tp : list) {
                List<String> str = new ArrayList<>();
                str.add(tp.getMessage());
                str.add(tp.getTwitterHandle());
                str.add(tp.getProfileImageURL());
                str.add(tp.getCreatedAt());
                twitterPost.add(str);
            }


            return twitterPost;
        }
        catch(TwitterException te){
            List<List<String>> lst = new ArrayList<List<String>>();
            List<String> list= new ArrayList<String>(Collections.singleton("Access Token not working"));
            lst.add(list);
            return lst;
        }

    }
}
