package com.achal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.achal.dao.TweetDAO;
import com.achal.model.Tweet;

@Controller
public class MainController {
	
	@Autowired
    private TweetDAO tweetDAO;

    // WELCOME PAGE - This is the welcome page of the application. 
	// If a user is logged in then it shows a list of most recent tweets (public tweets).
	// URL : http://localhost:8080/TwitterIntuit/
    // VERB : GET
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView welcomePage(ModelAndView model, @RequestParam(value = "search", defaultValue = "", required=false) String search) {
            List<Tweet> listTweets = tweetDAO.searchTweets(search);
            model.addObject("listTweets", listTweets);
            model.addObject("search", search);
            model.setViewName("welcomePage");
            return model;
        }

    // LOGIN PAGE - Login page to login to the system. 
    // URL : http://localhost:8080/TwitterIntuit/login - opens the login page
    // To do the actual login - you can use http://localhost:8080/TwitterIntuit/dologin
    // VERB : POST
    // Body : username : username
    //        password : password 
    // This will open the feeds page which shows the most recent tweets by the user that the current logged in user follows.
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model ) {
        return "loginPage";
    }


}