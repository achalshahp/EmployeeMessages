# TwitterIntuit
### A Twitter like REST service for Employees

#### Objective

As part of enhancing our internal services which are available to our employees, we would like to build a Twitter like solution for our employees, where employees can tweet and have followers. 

#### Requirements

1. Spring MVC
2. Spring JDBC Template
3. MySQL
4. Authentication using Spring Security
5. Maven

#### How To Run The Application

1. Clone the project from : https://github.com/achalshahp/TwitterIntuit or run this command :
    git clone https://github.com/achalshahp/TwitterIntuit.git

2. This project is expecting the user to have MySQL alreadys installed on their machine. If not you can get if from [here](https://dev.mysql.com/downloads/) or can even use brew to install, if you are running it on [MacOS](https://gist.github.com/nrollr/3f57fc15ded7dddddcc4e82fe137b58e).
3. There are two ways to push the data into the mysql db and tables.
   
   * **a)** Change your account to root and then issue the following two commands:
        * mysql < /PathtoTwitterIntuit/scripts/create_twitter_intuit.sql
        * mysql < /PathtoTwitterIntuit/scripts/populate_twitter_intuit.sql
   OR
   * **b)** Create the database 'twitterintuit' on MySQL
        * if need be, change the username and password on the file "[spring-database.xml](src/main/webapp/WEB-INF/spring-database.xml)"
        * Run the scripts present on the 'scripts' folder on the following order:
        * create_twitter_intuit.sql
        * populate_twitter_intuit.sql
4. Import the project to Eclipse or other IDE.
5. Run the project - Run as Server
6. Use the application on your browser or by doing requests to the API  
    If running from a browser go to : http://localhost:8080/TwitterIntuit/ 
  * to use the endpoints of the application, you first need to successfully login
7. Alternatively, for testing the CRUD actions you can even use [Postman](www.getpostman.com).

#### Authentication

* **POST** - /dologin - login to the application
  * parameters:
    * username - login username
    * password - login password
* **POST** - /logout - logout from the application

#### Endpoints

* **POST** - /tweet/create - create a new tweet
  * parameters:
    * tweet - text of the tweet to add
* **GET** - /tweets/all?search=[query] - search for tweets of all users
* **GET** - /feed- search for tweets of all the users followed by the logged in user
* **GET** - /tweets/[username]?search=[query] - search for tweets of specific user
* **GET** - /following - list of users the user follows
* **GET** - /followers - list of users that follow the user
* **POST** - /users/follow - start following a user
  * parameters:
    * username - username of the user to start following
* **POST** - /users/unfollow - start unfollowing a user
  * parameters:
    * username - username of the user to stop following
* **POST** - /delete - delete a tweet (only ADMIN users can access this feature)
  * parameters:
    * username - username of the user to delete tweet
    * tweet - the actual tweet


