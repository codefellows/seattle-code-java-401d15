# Composition and Inheritance, Part 2

## Overview

Our website, Zelp, is growing like crazy! Users are no longer satisfied with only reviewing restaurants: they also want to review shops, movie theaters, and museums. In today's lab, you'll create classes and interfaces to allow reviewing non-restaurant things, while ensuring some common functionality.

## Setup
Continue working in your `inheritance` library. Start by refactoring any of the relationships that you created in the last lab, but question today.

## Feature Tasks

1. The users want shops! Create a `Shop` class; a `Shop` should have a name, description, and number of dollar signs.
    - Implement a constructor for a `Shop`.
    - Implement a reasonable `toString` method for `Shop`s.
    - Add tests for the basics of your `Shop` class.
2. The users also want to review shops!
    - It would be great if a `Review` could be about either a `Shop` or a `Restaurant`. Choose an implementation, and make this possible.
    - Ensure that your `Shop` class has an instance method to add a review about that shop, and that it works just as well as the `Restaurant` instance method with the same purpose.
    - Write tests for this functionality.
3. The users want theaters! Create a `Theater` class; a `Theater` should have a name and all of the movies currently showing there. (Strings are fine for the movies; no need to create another class.)
    - Implement a constructor for a `Theater`.
    - Write `addMovie` and `removeMovie` instance methods that allow the theater to update which movies are being shown.
    - Implement a reasonable `toString` method for `Theater`s.
    - Test your `Theater` functionality.
4. Review all the things!
    - Ensure that your `Theater` is just as reviewable as your `Restaurant` and your `Shop`.
    - Test this functionality.
5. Users are frustrated: they like having a body, an author, and a number of stars, but when they're reviewing a `Theater`, they also want to specify which movie they saw.
    - Some reviews should now have a `String movie` instance variable, to hold which movie that reviewer is referencing.
    - Make sure that someone reviewing a `Restaurant` or a `Shop` doesn't have to include which movie they saw!
    - It's also okay if someone doesn't want to include the movie they saw when they're reviewing a theater (maybe they just went in for the popcorn).
    - Add testing for any new functionality you've created.

## Stretch Goals

### Yesterday's stretch goals only get more interesting today!

7. Add an `updateStars` method to the `Review` class. This method should update the stars for that review, and, if the review is associated with a restaurant (or other reviewable thing!), also update the number of stars for that reviewable thing.
8. Refactor: keeping track of stars is getting complicated. Get rid of that instance variable, and instead make this an instance method that calculates a reviewable's star rating on the fly when that instance method is called.
9. Create another class for a `User`, so that we know which reviews were written by the same `User`. Ensure that a single `User` can't submit multiple `Review`s for the same reviewable.

## Submission Instructions
* Continue working in your `java-fundamentals` repository.
* Work on a non-master branch and make commits appropriately.
* In your README file, include an overview of the architecture of your library, and directions on how to test your code.
* Ensure that you can test your code by running `./gradlew test`.
* Create a pull request to your master branch with your work for this lab.
* Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.

## Grading Rubric
- 2 pts `Shop` class, `toString` method, ability to review, and tests
- 2 pts `Theater` class, `toString` method, `addMovie` and `removeMovie` instance methods, ability to review, and tests
- 1 pt for overall functionality of all classes and tests
- 1 pt for README
