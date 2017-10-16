package com.achal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    @Override
    public int add(Tweet tweet) {
        String username = getUsername();
        String sql = "INSERT INTO tweets (tweet, user_username)" + " VALUES (?, ?)";
        try {
        	System.out.println("HERE THE TWEET IS : " + tweet.getTweet());
        	System.out.println("THE SQL INSIDE THE CREATE TWEET IS : " + sql);
            return jdbcTemplate.update(sql, tweet.getTweet(), username);
        }
        catch (DataIntegrityViolationException e) {
            return 0;
        }
    }
    
    @Override
    public List<Tweet> searchTweets(String search) {
    	System.out.println("NOW I AM INSIDE THE SEARCH TWEETS");
        String sql = "SELECT * FROM tweets WHERE tweet LIKE '%" + search + "%' ORDER BY tweet_id DESC";
        List<Tweet> listTweets = jdbcTemplate.query(sql, new RowMapper<Tweet>() {

            @Override
            public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tweet tweet = new Tweet();

            tweet.setId(rs.getInt("tweet_id"));
            tweet.setTweet(rs.getString("tweet"));
            tweet.setUser_username(rs.getString("user_username"));
            System.out.println("THE VALUE OF TWEET HERE IS : " + tweet);
            System.out.println("THE TWEET IN THIS ROUND IS" + tweet.getTweet());
            return tweet;
            }
        });

        return listTweets;
    }

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