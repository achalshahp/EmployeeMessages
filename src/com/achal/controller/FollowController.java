package com.achal.controller;

import com.achal.dao.FollowDAO;
import com.achal.model.Follow;
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
public class FollowController {

    @Autowired
    private FollowDAO followDAO;

    // FOLLOW AN USER - This can be used to follow an user from the follow/unfollow page.
    // POST call to follow an user e.g.
    // URL : http://localhost:8080/TwitterIntuit/users/follow
    // VERB : POST
    // Headers : Content-Type : application/x-www-form-urlencoded
    // Body : username : username
    //        password : password 
    @RequestMapping(value = "/users/follow", method = RequestMethod.POST, produces = {"application/json","application/xml"})
    @ResponseBody
    public ResponseEntity followUser(@ModelAttribute("followForm") UserStatus user) {
        int result = followDAO.follow(user.getUsername());
        if (result == 1) {
            return ResponseEntity.ok("{\"message\": \"Success!\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error!\"}");
        }
    }


    // UNFOLLOW USER- This can be used to unfollow an user from the follow/unfollow page.
    // POST call to unfollow an user e.g.
    // URL : http://localhost:8080/TwitterIntuit/users/unfollow
    // VERB : POST
    // Headers : Content-Type : application/x-www-form-urlencoded
    // Body : username : username
    //        password : password 
    @RequestMapping(value = "/users/unfollow", method = RequestMethod.POST, produces = {"application/json","application/xml"})
    @ResponseBody
    public ResponseEntity unfollowUser(@ModelAttribute("unfollowForm") UserStatus user) {
        int result = followDAO.unfollow(user.getUsername());
        if (result == 1) {
            return ResponseEntity.ok("{\"message\": \"Success!\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error!\"}");
        }
    }

    // FOLLOW PAGE - This will show a list of users and then you can call either follow/unfollow to follow/unfollow those users.
    // GET call to show the list of users e.g.
    // URL : http://localhost:8080/TwitterIntuit/users/
    // VERB : GET
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView followPage(ModelAndView model) {
        UserStatus followForm = new UserStatus();
        UserStatus unfollowForm = new UserStatus();
        model.addObject("followForm", followForm);
        model.addObject("unfollowForm", unfollowForm);

        List<UserStatus> listUsers = followDAO.listUsers();
        model.addObject("listUsers", listUsers);

        model.setViewName("follows/followPage");
        return model;
    }

    // FOLLOWING PAGE - This will show a list of users that the current logged in user is following.
    // GET call to how a list of users that the current logged in user is following e.g.
    // URL : http://localhost:8080/TwitterIntuit/following
    // VERB : GET
    @RequestMapping(value = "/following", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView following(ModelAndView model) {
        List<Follow> listFollowing = followDAO.listFollowing();
        model.addObject("listFollowing", listFollowing);
        model.setViewName("follows/followingPage");
        return model;
    }

    // FOLLOWERS PAGE- This will show a list of users that are following the current logged in user 
    // GET call to how a list of users that are following the current logged in user e.g.
    // URL : http://localhost:8080/TwitterIntuit/followers
    // VERB : GET
    @RequestMapping(value = "/followers", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView followers(ModelAndView model) {
        List<Follow> listFollowers = followDAO.listFollowers();
        model.addObject("listFollowers", listFollowers);
        model.setViewName("follows/followersPage");
        return model;
    }

    
}