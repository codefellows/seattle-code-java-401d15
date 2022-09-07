# Auth for Secret Recipe

## Resources
* [jBCrypt](https://www.mindrot.org/projects/jBCrypt/)

Create a server to protect a secret recipe by requiring users to sign up
for an account and log in. Users should only be able to see the recipe after
they've logged in and established an authenticated session.

Create the authentication system for this server on your own. Do not use Spring's own
built-in auth system.

Display a user's username somewhere on the page to indicate to a user that they're
logged in.

Use `Bcrypt` to hash and check user passwords. Make sure not to return user's
passwords or their hashes, if you return user information in the response to any request.

Do not code this in any of your existing projects. Otherwise, you will have to remove
this authentication code later when you do the Spring Security labs, which has
historically proven quite tricky.

Do not create a class named "User" for this project. If you do, Hibernate will be very
unhappy with you when you try to save it to the database.

## Feature Tasks
* Create a database.
* Create a table that models users with a username, id, and hashed password.
* Create a table that models posts with a postId, userId and text content.
* Create a table with a 1-to-many relationship between users and posts.
* Authenticate the site so only logged-in users can see posts.
* Use Bcrypt to hash all passwords stored on the site.

## Stretch Goals
* Add login / logout functionality using server sessions.

## Submission Instructions
* Continue working in your repository for the first 5 Spring labs.
* Work on a non-master branch and make commits appropriately.
* Ensure that you can run a single Gradle command to launch your server. Include that command in a README.md file.
* Create a pull request to your master branch with your work for this lab.
* Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.

## Grading Rubric
2 pts for proper use of bcrypt to hash passwords
2 pts for proper handling of login and sign up routes
1 pt for displaying logged-in user information
1 pt for README
