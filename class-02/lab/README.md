# Arrays, Loops, Imports, ArrayLists

## Overview

This lab is dedicated to creating, interacting with and manipulating arrays
in Java. Arrays in Java have a fixed size. Arrays are created with a certain
size and they never shrink or grow. Java arrays are typed. You can have an
array of integers, or an array of strings, but not an array mixed with
integers and strings.

Here's an example of how to create and interact with an array in Java.

```java
// a new array of integers starts with a value of zero for every index.
int[] temperatures = new int[7];
for (int i = 0; i < temperatures.length; i++) {
  System.out.println(temperatures[i]);
}

// a new array of strings starts with a value of null for every index.
String[] dayNames = new String[7];
for (int i = 0; i < dayNames.length; i++) {
  System.out.println(dayNames[i]);
}

// an array can be hard-coded with values initially using curly braces.
int[] daysInMonth = {31, 28, 31, 30, 31, 30,
                     31, 31, 30, 31, 30, 31};
String[] months = {"January", "February", "March", "April", "May", "June",
                   "July", "August", "September", "October", "November", "December"};

for (int i = 0; i < months.length; i++) {
  String message = "There are " + daysInMonth[i] + " days in " + months[i];
  System.out.println(message);
}
```

## Setup

Create a new directory in your `java-fundamentals` repo for lab 1; call that directory `basiclibrary`. Within that directory, run `gradle init --type java-library`. Write your methods and your tests for those methods within that new library.

## Feature Tasks
### Rolling Dice
Write a method called `roll` that accepts an integer `n` and rolls a six-sided
dice `n` times. The method should return an array containing the values of the
rolls.

```java
roll(4)
```

Should return something like:

```java
[3, 2, 1, 5]
```

### Contains Duplicates
Write a method called `containsDuplicates` that returns `true` or `false`
depending on whether the array contains duplicate values.

### Calculating Averages
Write a method that accepts an array of integers and calculates and returns
the average of all the values in the array.

### Arrays of Arrays
Given an array of arrays calculate the average value for each array and return
the array with the lowest average.

```java
// Daily average temperatures for Seattle, October 1-28 2017
int[][] weeklyMonthTemperatures = {
  {66, 64, 58, 65, 71, 57, 60},
  {57, 65, 65, 70, 72, 65, 51},
  {55, 54, 60, 53, 59, 57, 61},
  {65, 56, 55, 52, 55, 62, 57}
};
```

## Testing
* Use JUnit to write at least one test for each of the Feature Tasks.
  * Your tests should ensure that each of your methods work correctly.

## Submission Instructions
* Continue working in your repository for the first 5 labs.
* Work on a non-master branch and make commits appropriately.
* Ensure that you can run `./gradlew test` inside of your `basiclibrary` directory to test your work.
* Update your root README file to include the work you did today.
* Create a pull request to your master branch with your work for this lab.
* Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.

## Grading Rubric
- 1 point per function (half for method, half for test)
   - Roll Dice
   - Contains Duplicates
   - Calculating Averages
   - Array of arrays
- 1 point for tests running correctly
- 1 point for README
