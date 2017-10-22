package com.achal.controller;

<<<<<<< HEAD
import com.achal.dao.FollowDAO;
import com.achal.dao.TweetDAO;
import com.achal.model.Follow;
import com.achal.model.Tweet;
import com.achal.model.UserStatus;


import org.apache.commons.collections.ListUtils;
//import org.apache.tomcat.util.codec.binary.StringUtils;
=======
import com.achal.dao.TweetDAO;
import com.achal.model.Tweet;
import com.achal.model.UserStatus;

>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
<<<<<<< HEAD
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
=======

>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
import java.util.List;

@Controller
public class TweetController {

    @Autowired
    private TweetDAO tweetDAO;
<<<<<<< HEAD
    
    @Autowired
    private FollowDAO followDAO;

    // NEW TWEET PAGE  - loads the new tweet page.
=======

    // NEW TWEET PAGE
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
    @RequestMapping(value = "/tweet/new", method = RequestMethod.GET)
    public ModelAndView newTweet(ModelAndView model) {
        Tweet newTweet = new Tweet();
        model.addObject("tweet", newTweet);
        model.setViewName("tweets/newTweetPage");
        return model;
    }
    
<<<<<<< HEAD
    // DELETE TWEET PAGE - loads the delete tweet page. 
    //Only ADMIN users can access this page. Other users get a 401 Unauthorized.
=======
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
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
    
<<<<<<< HEAD
    // NEW TWEET - Create a new tweet for the logged in user.
    // URL : http://localhost:8080/TwitterIntuit/tweet/create
    // VERB : POST
    // Body (x-www-form-urlencoded) : tweet : tweet value
=======
    // NEW TWEET
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
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
    
<<<<<<< HEAD
    // GET ALL TWEETS - Returns all the tweets from all the users. (Like a public timeline).
    // URL : http://localhost:8080/TwitterIntuit/tweets/all
    // VERB : GET
    @RequestMapping(value = "/tweets/all", method = RequestMethod.GET)
=======
    // GET ALL TWEETS
    @RequestMapping(value = "/tweets/formatted", method = RequestMethod.GET)
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
    @ResponseBody
    public ModelAndView tweets(ModelAndView model, @RequestParam(value = "search", defaultValue = "", required=false) String search) {
        List<Tweet> listTweets = tweetDAO.searchTweets(search);
        model.addObject("listTweets", listTweets);
        model.addObject("search", search);
        model.setViewName("tweets/tweetsPage");
        return model;
    }
<<<<<<< HEAD
    
    // GET TWEETS FOR THE USERS FOLLOWED - Returns only the tweets from users that current logged in user follows.
    // Lists the most recent tweet first. This is the page that the logged in user see when he successfully logs in. 
    // URL : http://localhost:8080/TwitterIntuit/feed
    // VERB : GET
	@RequestMapping(value = "/feed", method = RequestMethod.GET)
    public ModelAndView tweetsForUsers(ModelAndView modelTweet) {
        Tweet newTweet = new Tweet();
        Follow newFollow = new Follow();
        System.out.println("INSIDE THE TWEETS FOR USER MODEL TO RETURN THE TWEET PAGE");
        List<Follow> listFollowing = followDAO.listFollowing();
        List<String> username = new ArrayList<>();
        System.out.println("THE LIST VALUES ARE : " + listFollowing);
        for (Follow user : listFollowing){
        	System.out.println(user.getUser_followed());
        	username.add(user.getUser_followed());        	
        	
        }
        
        // Done to join the list and make it a string to pass to the method to be used in the SQL IN Clause.
        String join = "'" + StringUtils.join(username,"','") + "'";
        List<Tweet> listTweets = tweetDAO.searchTweetsForUser(join);
        modelTweet.addObject("listTweets", listTweets);
        modelTweet.setViewName("tweets/tweetsForUser");
        return modelTweet;
    }

    // GET TWEETS OF A USER - Get a list of tweets for a specific user. Need to pass in the username.
	// URL : http://localhost:8080/TwitterIntuit/tweets/user1   ----- To get a list of tweets by User1. 
	// Optionally you can also pass a search criteria along with the usrername. 
    @RequestMapping(value = "/tweets/{username}", method = RequestMethod.GET)
=======

    // GET TWEETS OF A USER
    @RequestMapping(value = "/tweets/{username}/formatted", method = RequestMethod.GET)
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
    @ResponseBody
    public ModelAndView tweetsUser(ModelAndView model, @PathVariable String username, @RequestParam(value = "search", defaultValue = "", required=false) String search) {
        List<Tweet> listTweets = tweetDAO.searchUserTweets(username, search);
        model.addObject("listTweets", listTweets);
        model.addObject("username", username);
        model.addObject("search", search);
        model.setViewName("tweets/tweetsPage");
        return model;
    }

<<<<<<< HEAD
    //DELETE TWEET - Delete tweets. Shows a list of all the tweets with a Delete button next to them.
    // Only Admin users can access this feature.
    
=======
    //DELETE TWEET
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
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