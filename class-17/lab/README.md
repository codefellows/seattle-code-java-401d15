# CodeFellowship Profiles and Posts with Login

## Overview
Today, you'll enable logged-in users to edit their profiles and create posts.

## Setup
Continue working in your `codefellowship` repo.

## Resources
- [Spring Security cheat sheet](../../SpringSecurityCheatSheet.md)
- [Triggering 404 errors with an exception in Spring MVC](https://stackoverflow.com/questions/2066946/trigger-404-in-spring-mvc-controller)
- [Displaying dates using the #temporals Thymeleaf expression object (look at section 3)](https://www.baeldung.com/dates-in-thymeleaf)

## Feature Tasks
Allow users to log in to `CodeFellowship`, view user profiles, and create posts.

- Upon logging in, users should be taken to a `/myprofile` route that displays their information.
    - This should include a default profile picture, which is the same for every user, and their basic information from `ApplicationUser`.
- The site should have a page which allows viewing the data about a single `ApplicationUser`, at a route like `/users/{id}`.
    - This should include a default profile picture, which is the same for every user, and their basic information.
- Continue to ensure that your homepage, login, and registration routes are accessible to non-logged in users. All other routes should be limited to logged-in users.
- Add a `Post` entity to your app.
    - A `Post` has a `body` and a `createdAt` timestamp.
- A logged-in user should be able to create a `Post`, and a post should belong to the user that created it.
    - Hint: This is a relationship between two pieces of data
- A user's posts should be visible on their profile page.
- The site should use reusable templates for its information. (At a minimum, it should have one Thymeleaf fragment that is used on multiple pages.)
- The site should have a non-whitelabel error handling page that lets the user know, at minimum, the error code and a brief message about what went wrong.

## Stretch Goals
- A logged-in user should be able to edit their profile. (Double stretch: allow them to change their passwords if they enter their current password.)
- An "admin" user should be able to edit anyone's profile.

## Submission Instructions
* Continue working in your repository for this project.
* Work on a non-master branch and make commits appropriately.
* Ensure that you can run a single Gradle command to launch your server. Include that command, as well as a description of the project and the state of each of the feature tasks, in a README.md file.
* Create a pull request to your master branch with your work for this lab.
* Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.

## Grading Rubric
- 1pt / README
- 1pt / Upon signing up or logging in, users should be taken to a `/myprofile` route that displays their image and basic information. Their profile page should display their posts. Other users' profiles should be visible at `/users/{id}`.
- 1pt / Add a Post entity to your app with a body and a createdAt timestamp.
- 1pt / A logged-in user should be able to create a Post, and a post should belong to the user that created it.
- 1pt / Add a Thymeleaf fragment with reusable information on multiple pages.
- 1pt / Add a non-whitelabel error page.