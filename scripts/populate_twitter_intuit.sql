USE twitterintuit;
-- ADD USERS TO THE DATABASE

INSERT INTO users (username, password, enabled) VALUES ('jdoe', 'test', 1);
INSERT INTO users (username, password, enabled) VALUES ('jdoe1', 'password', 1);
INSERT INTO users (username, password, enabled) VALUES ('user1', 'pass', 1);
INSERT INTO users (username, password, enabled) VALUES ('user2', 'user2', 1);
INSERT INTO users (username, password, enabled) VALUES ('user3', 'user3', 1);
INSERT INTO users (username, password, enabled) VALUES ('user4', 'user4', 1);
INSERT INTO users (username, password, enabled) VALUES ('user5', 'user5', 1);
INSERT INTO users (username, password, enabled) VALUES ('user6', 'user6', 1);
INSERT INTO users (username, password, enabled) VALUES ('user7', 'user7', 1);

-- ADD USER ROLES TO THE DATABASE

INSERT INTO user_roles (user_username, role) VALUES ('jdoe', 'USER');
INSERT INTO user_roles (user_username, role) VALUES ('jdoe5', 'ADMIN');
INSERT INTO user_roles (user_username, role) VALUES ('user1', 'ADMIN');
INSERT INTO user_roles (user_username, role) VALUES ('user2', 'USER');
INSERT INTO user_roles (user_username, role) VALUES ('user3', 'USER');
INSERT INTO user_roles (user_username, role) VALUES ('user4', 'USER');
INSERT INTO user_roles (user_username, role) VALUES ('user5', 'USER');
INSERT INTO user_roles (user_username, role) VALUES ('user6', 'USER');
INSERT INTO user_roles (user_username, role) VALUES ('user7', 'USER');

-- ADD TWEETS TO THE DATABASE

INSERT INTO tweets (user_username, tweet) VALUES ('jdoe', 'Intuit did great today.. #Intuit');
INSERT INTO tweets (user_username, tweet) VALUES ('jdoe', 'GO Intuit');
INSERT INTO tweets (user_username, tweet) VALUES ('jdoe', 'Come join us for QBO ..#Intuit');
INSERT INTO tweets (user_username, tweet) VALUES ('jdoe1', 'Great presentation');
INSERT INTO tweets (user_username, tweet) VALUES ('jdoe1', 'Great workout today with @jdoe & @user1 Today');
INSERT INTO tweets (user_username, tweet) VALUES ('jdoe1', 'Tweet from jdoe1');
INSERT INTO tweets (user_username, tweet) VALUES ('jdoe1', 'NEw tweet here');
INSERT INTO tweets (user_username, tweet) VALUES ('jdoe', 'Great workout today with @jdoe1 & @user1 Today');
INSERT INTO tweets (user_username, tweet) VALUES ('jdoe', 'Loving the new twitter');
INSERT INTO tweets (user_username, tweet) VALUES ('user1', 'Tweet 2');
INSERT INTO tweets (user_username, tweet) VALUES ('user1', 'Loving the new twitter');
INSERT INTO tweets (user_username, tweet) VALUES ('user3', 'tweet 1 from user 3');
INSERT INTO tweets (user_username, tweet) VALUES ('user1', 'Tweet 1');
INSERT INTO tweets (user_username, tweet) VALUES ('user1', 'Tweet 2');
INSERT INTO tweets (user_username, tweet) VALUES ('user3', 'tweet 2 from user 3');
INSERT INTO tweets (user_username, tweet) VALUES ('user2', 'Loving the new twitter');
INSERT INTO tweets (user_username, tweet) VALUES ('user5', 'tweet 1 from user 5');
INSERT INTO tweets (user_username, tweet) VALUES ('user5', 'tweet 2 from user 5');
INSERT INTO tweets (user_username, tweet) VALUES ('user2', 'latest tweet by user 2');
INSERT INTO tweets (user_username, tweet) VALUES ('user1', 'latest tweet from user1');
INSERT INTO tweets (user_username, tweet) VALUES ('user4', 'i am tweeting ');
INSERT INTO tweets (user_username, tweet) VALUES ('user4', 'Loving the new twitter');
INSERT INTO tweets (user_username, tweet) VALUES ('user3', 'hellllloooo @jdoe & @jdoe1');
INSERT INTO tweets (user_username, tweet) VALUES ('user6', 'Tweet 1');
INSERT INTO tweets (user_username, tweet) VALUES ('user7', 'Tweet 2');
INSERT INTO tweets (user_username, tweet) VALUES ('user5', 'Tweet 3');
INSERT INTO tweets (user_username, tweet) VALUES ('user1', 'Join us today for our demo.. #Intuit');
INSERT INTO tweets (user_username, tweet) VALUES ('user1', 'Tweet 2');
INSERT INTO tweets (user_username, tweet) VALUES ('user3', 'Tweet 3');
INSERT INTO tweets (user_username, tweet) VALUES ('user7', 'Join us today for our demo.. #Intuit');
INSERT INTO tweets (user_username, tweet) VALUES ('user5', 'Tweet 2017');
INSERT INTO tweets (user_username, tweet) VALUES ('user4', 'Joining the crowd today at Intuit show..');
INSERT INTO tweets (user_username, tweet) VALUES ('user1', 'Come join us on Oct 24');
INSERT INTO tweets (user_username, tweet) VALUES ('user6', 'Join us today for our demo.. #Intuit');
INSERT INTO tweets (user_username, tweet) VALUES ('user3', 'This is user 3 tweeting');
INSERT INTO tweets (user_username, tweet) VALUES ('user4', 'This is my tweet');
INSERT INTO tweets (user_username, tweet) VALUES ('user6', '@jdoe - great presentation today..');
INSERT INTO tweets (user_username, tweet) VALUES ('user7', '@jdoe - great presentation today..');


-- ADD FOLLOWERS TO THE DATABASE

INSERT INTO follows (user_followed, follower) VALUES ('jdoe', 'user1');
INSERT INTO follows (user_followed, follower) VALUES ('jdoe', 'jdoe1');
INSERT INTO follows (user_followed, follower) VALUES ('jdoe', 'user2');
INSERT INTO follows (user_followed, follower) VALUES ('jdoe', 'user7');
INSERT INTO follows (user_followed, follower) VALUES ('jdoe1', 'jdoe');
INSERT INTO follows (user_followed, follower) VALUES ('jdoe1', 'user1');
INSERT INTO follows (user_followed, follower) VALUES ('jdoe1', 'user3');
INSERT INTO follows (user_followed, follower) VALUES ('jdoe1', 'user5');
INSERT INTO follows (user_followed, follower) VALUES ('user1', 'user2');
INSERT INTO follows (user_followed, follower) VALUES ('user2', 'user1');
INSERT INTO follows (user_followed, follower) VALUES ('user1', 'user3');
INSERT INTO follows (user_followed, follower) VALUES ('user1', 'jdoe');
INSERT INTO follows (user_followed, follower) VALUES ('user2', 'jdoe');
INSERT INTO follows (user_followed, follower) VALUES ('user1', 'jdoe1');
INSERT INTO follows (user_followed, follower) VALUES ('user1', 'user5');
INSERT INTO follows (user_followed, follower) VALUES ('user2', 'user7');
INSERT INTO follows (user_followed, follower) VALUES ('user1', 'user6');
INSERT INTO follows (user_followed, follower) VALUES ('jdoe', 'user3');
INSERT INTO follows (user_followed, follower) VALUES ('user2', 'user6');
INSERT INTO follows (user_followed, follower) VALUES ('user4', 'user3');
INSERT INTO follows (user_followed, follower) VALUES ('user3', 'user2');
INSERT INTO follows (user_followed, follower) VALUES ('user6', 'user1');
INSERT INTO follows (user_followed, follower) VALUES ('user7', 'user3');
