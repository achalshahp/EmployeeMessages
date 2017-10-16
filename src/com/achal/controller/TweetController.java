package com.achal.controller;

import com.achal.dao.TweetDAO;
import com.achal.model.Tweet;
import com.achal.model.UserStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TweetController {

    @Autowired
    private TweetDAO tweetDAO;

    // NEW TWEET PAGE
    @RequestMapping(value = "/tweet/new", method = RequestMethod.GET)
    public ModelAndView newTweet(ModelAndView model) {
        Tweet newTweet = new Tweet();
        model.addObject("tweet", newTweet);
        model.setViewName("tweets/newTweetPage");
        return model;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delTweet(ModelAndView modeldel) {
        Tweet newTweet = new Tweet();
        System.out.println("INSIDE THE TWEET MODEL TO RETURN THE TWEET PAGE");
        //modeldel.addObject("tweet", newTweet);
        String search = "";
        List<Tweet> listTweets = tweetDAO.searchTweets(search);
        modeldel.addObject("listTweets", listTweets);
        modeldel.setViewName("tweets/deleteTweets");
        return modeldel;
    }
    
    // NEW TWEET
    @RequestMapping(value = "/tweet/create", method = RequestMethod.POST, produces = {"application/json","application/xml"})
    @ResponseBody
    public ResponseEntity createTweet(@ModelAttribute("tweetForm") Tweet tweet) {
        int result = tweetDAO.add(tweet);
        System.out.println("THE VALUE OF RESULT IN CREATE TWEET IS : " + result);
        if (result == 1) {
        	
            return ResponseEntity.ok("{\"message\": \"Success!\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error!\"}");
        }
    }
    
    // GET ALL TWEETS
    @RequestMapping(value = "/tweets/formatted", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView tweets(ModelAndView model, @RequestParam(value = "search", defaultValue = "", required=false) String search) {
        List<Tweet> listTweets = tweetDAO.searchTweets(search);
        model.addObject("listTweets", listTweets);
        model.addObject("search", search);
        model.setViewName("tweets/tweetsPage");
        return model;
    }

    // GET TWEETS OF A USER
    @RequestMapping(value = "/tweets/{username}/formatted", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView tweetsUser(ModelAndView model, @PathVariable String username, @RequestParam(value = "search", defaultValue = "", required=false) String search) {
        List<Tweet> listTweets = tweetDAO.searchUserTweets(username, search);
        model.addObject("listTweets", listTweets);
        model.addObject("username", username);
        model.addObject("search", search);
        model.setViewName("tweets/tweetsPage");
        return model;
    }

    //DELETE TWEET
    @RequestMapping(value = "/deleteTweet", method = RequestMethod.POST, produces = {"application/json","application/xml"})
    @ResponseBody
    public ResponseEntity deleteTweet(Tweet username,Tweet tweet) {
    	System.out.println("I AM INSIDE THE ACTUAL DELETE");
    	System.out.println("INSIDE THE DELETE TWEET THE VALUE OF TWEEET IS : " + tweet.getTweet());
    	//System.out.println("INSIDE THE DELETE TWEET THE VALUE OF USERNAME IS : " + user_username.getUser_username());
        //UserStatus unfollowForm = new UserStatus();
        int result = tweetDAO.delete(username, tweet);
        System.out.println("THE RESULT VALUE IS : " + result);
    	//int result = tweetDAO.delete(tweet);
        if (result == 1) {
        	return ResponseEntity.ok("{\"message\": \"Success!\"}");
        	}
        else {
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error!\"}");
        }
   }
}