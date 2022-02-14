package com.twitter.controller;

import com.twitter.Resources.AddingTweets;
import com.twitter.Resources.FilterTimeline;
import com.twitter.Resources.GettingTimeline;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import twitter4j.TwitterException;

import java.io.IOException;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path= "/api/1.0/twitter")
public class TwitterRestController {
    @RequestMapping(value="/timeline", method= RequestMethod.GET)
    public List<List<String>> getTimeline() {
        GettingTimeline gettingTimeline= new GettingTimeline();
//        return gettingTimeline.getTimeline();

        List<List<String>> msg= gettingTimeline.getTimeline();
        return msg;
    }

    @RequestMapping(value="/tweet", method=RequestMethod.POST)
    public String addingTweet(@RequestBody String args){
        AddingTweets addingtweet= new AddingTweets();
        //return addingtweet.addingTweet(args);
        String msg= addingtweet.addingTweet(args);
        return msg;

    }

    @RequestMapping(path="/timeline/{filter}", method=RequestMethod.GET)
     public  List<String> searchtweets(@PathVariable("filter") String filter) {
        FilterTimeline filterTimeline= new FilterTimeline();
        return filterTimeline.searchtweets(filter);

    }
}