package com.achal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.achal.model.Follow;
import com.achal.model.UserStatus;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class FollowDAOImpl implements FollowDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    // Update the db to insert a new user being followed by the logged in user.
    @Override
    public int follow(String user) {
        String username = getUsername();
        String sql = "INSERT INTO follows (user_followed, follower)" + " VALUES (?, ?)";
        try {
            return jdbcTemplate.update(sql, user, username);
        }
        catch (DataIntegrityViolationException e) {
            return 0;
        }
    }

    // Update the db to remove a user being followed by the logged in user.
    @Override
    public int unfollow(String user){
        String username = getUsername();
        String sql = "DELETE FROM follows WHERE user_followed = ? AND follower = ?";
        try {
            return jdbcTemplate.update(sql, user, username);
        }
        catch (DataIntegrityViolationException e) {
            return 0;
        }
    }
    
    // Get a list of users and toggle the follow/unfollow button based on the data from db.
    @Override
    public List<UserStatus> listUsers(){
        final String username = getUsername();
        String sql = "SELECT * FROM users WHERE NOT username = '" + username + "' ORDER BY username ASC";
        List<UserStatus> listUsers = jdbcTemplate.query(sql, new RowMapper<UserStatus>() {

            @Override
            public UserStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserStatus user = new UserStatus();

            user.setUsername(rs.getString("username"));

            String sql_aux = "SELECT EXISTS(SELECT 1 FROM follows WHERE user_followed = '" + user.getUsername() + "' AND follower = '" + username + "' LIMIT 1)";
            int result = jdbcTemplate.queryForObject(sql_aux, Integer.class);
            if (result==1) {
                user.setStatus(true);
            }
            else {
                user.setStatus(false);
            }

            return user;
            }
        });

        return listUsers;
    }
    
    // Get the list of all users that the current logged in user is following from the db.
    @Override
    public List<Follow> listFollowing(){
        String username = getUsername();
        String sql = "SELECT * FROM follows WHERE follower = '" + username + "'ORDER BY user_followed ASC";
        List<Follow> listFollowing = jdbcTemplate.query(sql, new RowMapper<Follow>() {

            @Override
            public Follow mapRow(ResultSet rs, int rowNum) throws SQLException {
            Follow follow = new Follow();

            follow.setUser_followed(rs.getString("user_followed"));

            return follow;
            }
        });

        return listFollowing;
    }

    // Get the list of all users that are following the current logged in use from the db.
    @Override
    public List<Follow> listFollowers(){
        String username = getUsername();
        String sql = "SELECT * FROM follows WHERE user_followed = '" + username + "'ORDER BY follower ASC";
        List<Follow> listFollowers = jdbcTemplate.query(sql, new RowMapper<Follow>() {

            @Override
            public Follow mapRow(ResultSet rs, int rowNum) throws SQLException {
            Follow follow = new Follow();

            follow.setFollower(rs.getString("follower"));

            return follow;
            }
        });

        return listFollowers;
    }

    public String getUsername() {
        String aux;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            aux = ((UserDetails)principal).getUsername();
        } else {
            aux = principal.toString();
        }
        return aux;
    }
}
