# Spring RESTful Routing

## Resources
* [Baeldung: Spring Request Mapping](http://www.baeldung.com/spring-requestmapping)

## Setup
Continue working in the same `songr` webapp you generated for the previous lab. Ensure that you have all of these dependencies in your `build.gradle`. (Note that when you add the dependencies on postgres and JPA, your app will stop working until you have the configuration in `application.properties` to access your Postgres database.)

```
dependencies {
	implementation('org.springframework.boot:spring-boot-starter-data-jpa')
	implementation('org.springframework.boot:spring-boot-starter-thymeleaf')
	implementation('org.springframework.boot:spring-boot-starter-web')
	runtimeOnly('org.postgresql:postgresql')
	testImplementation('org.springframework.boot:spring-boot-starter-test')
}
```

## Feature Tasks
- Update your `Album` model so that it can be saved in a database.
    - An `Album` has a `title`, an `artist`, a `songCount`, a `length` (in seconds), and an `imageUrl` that is a link to that album's art.
- A user should be able to see information about all the albums on the site.
- A user should be able to add albums to the site.

## Stretch Goals
- A user should be able to update information about albums on the site.
- A user should be able to delete albums on the site.

## Planning
You'll need to plan your steps carefully to succeed in this lab. Build incrementally, and make sure to try each new route as you create it. Try to isolate issues as they come up: exactly what about your app is not currently working the way you expected? Work on the feature tasks in isolation, and ensure that each is functional before moving on to the next.

## Testing
We will talk more about integration testing in future lectures. For now, visually ensure that each of your routes is working. You are NOT required to write any tests for this lab.

Make sure your server fails gracefully. The server shouldn't crash and the
database shouldn't be corrupted in any way if a user attempts to read or
manipulate information that doesn't exist.

## Submission Instructions
* Continue working in your `songr` repository.
* Work on a non-master branch and make commits appropriately.
* Ensure that you can run a single Gradle command to launch your server. Include that command in a README.md file.
* Create a pull request to your master branch with your work for this lab.
* Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.

## Grading Rubric
- 1 pt: Album class and properties
- 1 pt: Add album functionality on site and associated method
- 1 pt: The information for all albums should be visible on the Albums page
- 1 pt: All functions and routes work (visual verification only)
- 1 pt: Update README to include instructions on how to run the program (including command line and updating application.properties if necessary)
- 1 pt: Invalid inputs should error gracefully - doesn't crash server or database
