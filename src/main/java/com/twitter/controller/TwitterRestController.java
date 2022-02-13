package com.twitter.controller;

import com.twitter.Resources.AddingTweets;
import com.twitter.Resources.FilterTimeline;
import com.twitter.Resources.GettingTimeline;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path= "/api/1.0/twitter")
public class TwitterRestController {
    ApplicationContext applicationContext= new ClassPathXmlApplicationContext("beans.xml");
    @RequestMapping(value="/timeline", method= RequestMethod.GET)
    public List<List<String>> getTimeline() {
        GettingTimeline gettingTimeline= applicationContext.getBean("gettingTimeline", GettingTimeline.class);
//        return gettingTimeline.getTimeline();

        List<List<String>> msg= gettingTimeline.getTimeline();
        return msg;
    }

    @RequestMapping(value="/tweet", method=RequestMethod.POST)
    public String addingTweet(@RequestBody String args){
        AddingTweets addingtweet= applicationContext.getBean("addingTweet", AddingTweets.class);
        //return addingtweet.addingTweet(args);
        String msg= addingtweet.addingTweet(args);
        return msg;

    }

    @RequestMapping(path="/timeline/{filter}", method=RequestMethod.GET)
     public  List<String> searchtweets(@PathVariable("filter") String filter) {
        FilterTimeline filterTimeline= applicationContext.getBean("filterTimeline", FilterTimeline.class);
        return filterTimeline.searchtweets(filter);

    }
}