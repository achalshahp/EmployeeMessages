package com.achal.dao;

import java.util.List;

<<<<<<< HEAD
import com.achal.model.Follow;
=======
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
import com.achal.model.Tweet;
import com.achal.model.UserStatus;

public interface TweetDAO {

    int add(Tweet tweet);
    List<Tweet> searchTweets(String search);
    List<Tweet> searchUserTweets(String username, String search);
    int delete(Tweet user_username, Tweet tweet);
<<<<<<< HEAD
	//List<Tweet> searchTweetsForUser(String username);
    List<Tweet> searchTweetsForUser(String username);
=======
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
}