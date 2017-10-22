package com.achal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;
import java.util.Map;
=======
import java.util.List;
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4

import javax.sql.DataSource;

import com.achal.model.Tweet;
import com.achal.model.UserStatus;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class TweetDAOImpl implements TweetDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
<<<<<<< HEAD
    
    // Insert into the db the values of a new tweet.
=======

>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
    @Override
    public int add(Tweet tweet) {
        String username = getUsername();
        String sql = "INSERT INTO tweets (tweet, user_username)" + " VALUES (?, ?)";
        try {
<<<<<<< HEAD
=======
        	System.out.println("HERE THE TWEET IS : " + tweet.getTweet());
        	System.out.println("THE SQL INSIDE THE CREATE TWEET IS : " + sql);
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
            return jdbcTemplate.update(sql, tweet.getTweet(), username);
        }
        catch (DataIntegrityViolationException e) {
            return 0;
        }
    }
    
<<<<<<< HEAD
    // Search and return all the tweets
    @Override
    public List<Tweet> searchTweets(String search) {
=======
    @Override
    public List<Tweet> searchTweets(String search) {
    	System.out.println("NOW I AM INSIDE THE SEARCH TWEETS");
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
        String sql = "SELECT * FROM tweets WHERE tweet LIKE '%" + search + "%' ORDER BY tweet_id DESC";
        List<Tweet> listTweets = jdbcTemplate.query(sql, new RowMapper<Tweet>() {

            @Override
            public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tweet tweet = new Tweet();

            tweet.setId(rs.getInt("tweet_id"));
            tweet.setTweet(rs.getString("tweet"));
            tweet.setUser_username(rs.getString("user_username"));
<<<<<<< HEAD
=======
            System.out.println("THE VALUE OF TWEET HERE IS : " + tweet);
            System.out.println("THE TWEET IN THIS ROUND IS" + tweet.getTweet());
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
            return tweet;
            }
        });

        return listTweets;
    }
<<<<<<< HEAD
    
    // Search and return only the tweets for a specific user.
=======

>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
    @Override
    public List<Tweet> searchUserTweets(String username, String search) {
        String sql = "SELECT * FROM tweets WHERE user_username = '"+ username+"' AND tweet LIKE '%" + search + "%' ORDER BY tweet_id DESC";
        List<Tweet> listTweets = jdbcTemplate.query(sql, new RowMapper<Tweet>() {

            @Override
            public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tweet tweet = new Tweet();

            tweet.setId(rs.getInt("tweet_id"));
            tweet.setTweet(rs.getString("tweet"));
            tweet.setUser_username(rs.getString("user_username"));

            return tweet;
            }
        });

        return listTweets;
    }
    
<<<<<<< HEAD
    // Delete tweet from the db.
    @Override
	public int delete(Tweet user_username, Tweet tweet) {
		String tweet_here = tweet.getTweet();
		System.out.println("THE VALUE OF TWEET BEFORE SPLITTING IS : " + tweet_here);
		String username = tweet_here.split(",")[0];
		System.out.println("THE USERNAME IS : " + username);
		String tweetDelete = tweet_here.split(",")[1]; 
		
		String sql = "DELETE from tweets where user_username = ? AND tweet = ?";
        try {
        	int rowCount = jdbcTemplate.update(sql,new Object[] {username,tweetDelete});
            System.out.println("THE NO OF ROWS DELETED IS : " + rowCount);
            return rowCount;
=======
    @Override
	public int delete(Tweet user_username, Tweet tweet) {
		String tweet_here = tweet.getTweet();
		String username = tweet_here.split(",")[0];
		String tweetDelete = tweet_here.split(",")[1]; 
		String sql = "DELETE from tweets where user_username = ? AND tweet = ?";
        try {
        	int abc = jdbcTemplate.update(sql,new Object[] {username,tweetDelete});
            System.out.println("THE NO OF ROWS DELETED IS : " + abc);
            return abc;
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
        }
        catch (DataIntegrityViolationException e) {
            return 0;
        }
	}
<<<<<<< HEAD
    
    // Search and return a list of tweets for only the users followed by the current logged in user.
    @Override
    public List<Tweet> searchTweetsForUser(String username) {
    	List<Tweet> listTweets = jdbcTemplate.query("SELECT user_username,tweet FROM tweets WHERE user_username IN (" + username + ") "
    			+ "ORDER BY tweet_id DESC", new RowMapper<Tweet>() {

            @Override
            public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tweet tweet = new Tweet();
            tweet.setTweet(rs.getString("tweet"));
            tweet.setUser_username(rs.getString("user_username"));
         
            return tweet;
            }
        });
        return listTweets;
	}
=======
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4

    public String getUsername() {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
}