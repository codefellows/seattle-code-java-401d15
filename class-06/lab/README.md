# Composition and Inheritance, Part 1

## Overview

In today's lab, you'll create classes to represent reviews of restaurants.

## Setup
Within the `java-fundamentals` repo, create a directory named `inheritance`. `cd` into that directory, and run `gradle init --type java-library`.

## Feature Tasks

1. Create a class to represent a `Restaurant`. Each `Restaurant` should have a name, a number of stars betweeen 0 and 5, and a price category (i.e. number of dollar signs).
    - Implement a `Restaurant` constructor.
    - Test that your `Restaurant` constructor is behaving reasonably.
    - Implement a reasonable `toString` method for `Restaurant`s.
    - Write a test to create an instance of `Restaurant` and ensure that its `toString` is working properly.
2. Create a class to represent a `Review`. Each `Review` should have a body, an author, and a number of stars.
    - Write a `Review` constructor.
    - Test that your constructor is working reasonably.
    - Implement a reasonable `toString` method for `Review`s.
    - Write a test to create an instance of `Review` and ensure that its `toString` is working properly.
3. A `Review` should be about a single `Restaurant`. Choose an implementation for this, and implement it. Some considerations:
    - Should a `Review` know which `Restaurant` it is about?
    - Should a `Restaurant` know which `Reviews` are about it?
    - Is a `Restaurant` a special type of `Review`? Is a `Review` a special type of `Restaurant`? Is there common functionality that unites them?
    - Update your `toString` and constructor methods appropriately, and also update your testing code to test this new functionality.
4. Add an instance method `addReview` to your `Restaurant` class. This method should take in a `Review` instance, and associate that review with `this Restaurant`. The specific methodology for this will vary, depending on the implementation you chose above.
    - Add tests to ensure that when you call `addReview`, the association is created between the `Restaurant` and the `Review`.
5. When you associate a review with a restaurant, that restaurant's star rating should change. Ensure that your `addReview` method updates the `Restaurant` star rating appropriately, and add tests. (In particular, ensure that if you're trying to call `addReview` when the restaurant and the review are already associated, the star rating of the restaurant does not update.)

## Stretch Goals

6. Some `Restaurant`s are part of a chain, and it would be nice to capture, for example, that all of the McDonald's locations are McDonaldses.
    - Choose an implementation for this, and implement it.
    - Add tests for this functionality.
7. Add an `updateStars` method to the `Review` class. This method should update the stars for that review, and, if the review is associated with a restaurant, also update the number of stars for that restaurant.
8. Refactor: keeping track of stars for restaurants is getting complicated. Get rid of that instance variable, and instead make this an instance method that calculates a restaurant's star rating on the fly when it's called.
9. Create another class for a `User`, so that we know which reviews were written by the same `User`. Ensure that a single `User` can't submit multiple `Review`s for the same `Restaurant`.

## Submission Instructions
* Continue working in your `java-fundamentals` repository.
* Work on a non-master branch and make commits appropriately.
* In your README file, include an overview of the architecture of your library, and directions on how to test your code.
* Ensure that you can test your code by running `./gradlew test`.
* Create a pull request to your master branch with your work for this lab.
* Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.

## Grading Rubric
- 2 pts `Restaurant` class, `toString` method, and test
- 2 pts `Review` class, `toString` method, and test
- 1 pt for addReview instance method, and test
- 1 pt for README
