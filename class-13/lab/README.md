# Related Resources and Integration Testing

## Resources
* [Related data in Spring (focus on the relationship annotations, not the curl requests)](https://www.baeldung.com/spring-data-rest-relationships)
* [Baeldung: Spring Integration Testing](https://www.baeldung.com/integration-testing-in-spring)

## Setup
Continue working in the same repository as your previous two labs.

## Feature Tasks
- Create a `Song` model.
    - A `Song` has a `title`, a `length` (in seconds), a `trackNumber`, and the `album` on which that song appears.
    - Ensure that the relationship between `Albums` and `Songs` is appropriately set up.
- A user should be able to see information about all the songs on the site.
- A user should be able to view a page with data about one particular album.
- A user should be able to add songs to an album.
    - A user should be able to see the songs that belong to an album when looking at that album.

## Stretch Goals
- A user should be able to update information about songs on the site.
- A user should be able to delete songs on the site.
- A user should be able to delete albums on the site, and when they do, all associated songs should also be deleted.

## Testing
Write integration tests for your hello world routes.

As a stretch goal, add integration testing for the routes you've created today.

Make sure your server fails gracefully. The server shouldn't crash and the
database shouldn't be corrupted in any way if a user attempts to read or
manipulate information that doesn't exist.

## Submission Instructions
* Continue working in your repository for the first 5 Spring labs.
* Work on a non-master branch and make commits appropriately.
* Ensure that you can run a single Gradle command to launch your server. Include that command in a README.md file.
* Create a pull request to your master branch with your work for this lab.
* Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.

## Grading Rubric
- 1pt Able to view a page with data about one particular album
- 1pt Able to add songs to an album
- 1pt Able to see the songs that belong to an album when looking at that album
- 2 pts Working integration tests for your hello world routes
- 1 pt README
