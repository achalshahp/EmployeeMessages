package com.achal.dao;

import java.util.List;

import com.achal.model.Follow;
import com.achal.model.Tweet;
import com.achal.model.UserStatus;

public interface TweetDAO {

    int add(Tweet tweet);
    List<Tweet> searchTweets(String search);
    List<Tweet> searchUserTweets(String username, String search);
    int delete(Tweet user_username, Tweet tweet);
	//List<Tweet> searchTweetsForUser(String username);
    List<Tweet> searchTweetsForUser(String username);
}