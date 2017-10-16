package com.achal.dao;

import java.util.List;

import com.achal.model.Follow;
import com.achal.model.UserStatus;

public interface FollowDAO {

    int follow(String user);
    int unfollow(String user);
    List<UserStatus> listUsers();
    List<Follow> listFollowing();
    List<Follow> listFollowers();
}