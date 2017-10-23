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
    
    // Insert into the db the values of a new tweet.
    @Override
    public int add(Tweet tweet) {
        String username = getUsername();
        String sql = "INSERT INTO tweets (tweet, user_username)" + " VALUES (?, ?)";
        try {
            return jdbcTemplate.update(sql, tweet.getTweet(), username);
        }
        catch (DataIntegrityViolationException e) {
            return 0;
        }
    }
    
    // Search and return all the tweets
    @Override
    public List<Tweet> searchTweets(String search) {
    @Override
    public List<Tweet> searchTweets(String search) {
        String sql = "SELECT * FROM tweets WHERE tweet LIKE '%" + search + "%' ORDER BY tweet_id DESC";
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
    
    // Search and return only the tweets for a specific user.
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
            return rowCount;
        }
        catch (DataIntegrityViolationException e) {
            return 0;
        }
	}
    
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