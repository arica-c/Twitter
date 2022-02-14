package com.twitter.controller;

import com.twitter.starter.AddingTweets;
import com.twitter.starter.GettingTimeline;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path= "/api/1.0/twitter")
public class TwitterRestController {
    @RequestMapping(value="/timeline", method= RequestMethod.GET)
    public List<String> getTimeline() {
        GettingTimeline gettingTimeline= new GettingTimeline();
//        return gettingTimeline.getTimeline();

        List<String> msg= gettingTimeline.getTimeline();
        if(msg.get(0).equals("Access Token not working")) {
            return msg;

        }
        else if(msg.get(0).equals("Exception raised while reading the application file"))
        {
            return msg;
        }
        else
        {
            return msg;
        }
    }

    @RequestMapping(value="/tweet", method=RequestMethod.POST)
    public String addingTweet(@RequestBody String args){
        AddingTweets addingtweet= new AddingTweets();
        //return addingtweet.addingTweet(args);
        String msg= addingtweet.addingTweet(args);
        if(msg.equals("Check your access tokens")){
            return msg;
        }
        else {
            return msg;
        }
    }
}