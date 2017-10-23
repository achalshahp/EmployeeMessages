package com.achal.controller;


import com.achal.dao.FollowDAO;
import com.achal.dao.TweetDAO;
import com.achal.model.Follow;
import com.achal.model.Tweet;
import com.achal.model.UserStatus;
import org.apache.commons.collections.ListUtils;
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
import org.apache.commons.lang.StringUtils;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TweetController {

    @Autowired
    private TweetDAO tweetDAO;

    
    @Autowired
    private FollowDAO followDAO;

    // NEW TWEET PAGE  - loads the new tweet page.
    @RequestMapping(value = "/tweet/new", method = RequestMethod.GET)
    public ModelAndView newTweet(ModelAndView model) {
        Tweet newTweet = new Tweet();
        model.addObject("tweet", newTweet);
        model.setViewName("tweets/newTweetPage");
        return model;
    }
    
    // DELETE TWEET PAGE - loads the delete tweet page. 
    //Only ADMIN users can access this page. Other users get a 401 Unauthorized.
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
    
    // NEW TWEET - Create a new tweet for the logged in user.
    // URL : http://localhost:8080/TwitterIntuit/tweet/create
    // VERB : POST
    // Body (x-www-form-urlencoded) : tweet : tweet value
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
    
    // GET ALL TWEETS - Returns all the tweets from all the users. (Like a public timeline).
    // URL : http://localhost:8080/TwitterIntuit/tweets/all
    // VERB : GET
    @RequestMapping(value = "/tweets/all", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView tweets(ModelAndView model, @RequestParam(value = "search", defaultValue = "", required=false) String search) {
        List<Tweet> listTweets = tweetDAO.searchTweets(search);
        model.addObject("listTweets", listTweets);
        model.addObject("search", search);
        model.setViewName("tweets/tweetsPage");
        return model;
    }
    
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
    @ResponseBody
    public ModelAndView tweetsUser(ModelAndView model, @PathVariable String username, @RequestParam(value = "search", defaultValue = "", required=false) String search) {
        List<Tweet> listTweets = tweetDAO.searchUserTweets(username, search);
        model.addObject("listTweets", listTweets);
        model.addObject("username", username);
        model.addObject("search", search);
        model.setViewName("tweets/tweetsPage");
        return model;
    }

    //DELETE TWEET - Delete tweets. Shows a list of all the tweets with a Delete button next to them.
    // Only Admin users can access this feature.
    @RequestMapping(value = "/deleteTweet", method = RequestMethod.POST, produces = {"application/json","application/xml"})
    @ResponseBody
    public ResponseEntity deleteTweet(Tweet username,Tweet tweet) {
        int result = tweetDAO.delete(username, tweet);
        if (result == 1) {
        	return ResponseEntity.ok("{\"message\": \"Success!\"}");
        	}
        else {
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error!\"}");
        }
   }
}