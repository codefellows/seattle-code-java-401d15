# Adding Data to TaskMaster

## Overview
Today, you'll add the ability to send data among different activities in your application using SharedPreferences and Intents.

## Setup
Continue working in your `taskmaster` repository.

## Resources
  * [Android SharedPreferences](https://developer.android.com/training/data-storage/shared-preferences){:_target="blank"}
  * [The Activity Lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle){:_target="blank"}
  * [Android Studio user guide](https://developer.android.com/studio/intro){:_target="blank"}

## Feature Tasks
### Task Detail Page
Create a Task Detail page. It should have a title at the top of the page, and a Lorem Ipsum description.

### Settings Page
Create a Settings page. It should allow users to enter their username and hit save.

### Homepage
The main page should be modified to contain three different buttons with hardcoded task titles. When a user taps one of the titles, it should go to the Task Detail page, and the title at the top of the page should match the task title that was tapped on the previous page. 

The homepage should also contain a button to visit the Settings page, and once the user has entered their username, it should display "{username}'s tasks" above the three task buttons.

## Documentation
Replace your homepage screenshot and add a screenshot of your Task Detail page into your repo, and update your daily change log with today's changes.

## Testing
In a future lecture, we'll talk about how to test Android UI using Espresso. For now, ensure that you're writing good unit tests for anything unit-testable in your code.

## Stretch Goals
* Consider the styling for this app. Decide on a color scheme and font families to use. (You'll thank yourself later for doing this work now!)
* Allow the user to specify on their settings page how many tasks should be shown on the homepage. Use this to dynamically create buttons for as many tasks as the user requests.

## Submission Instructions
* Continue working in your `taskmaster` repo.
* Work on a non-master branch and make commits appropriately.
* Update your README with your changes for today and screenshot of your work.
* Create a pull request to your master branch with your work for this lab.
* Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.

## Grading Rubric
- 1 pt   Task detail page exists & is reachable from homepage
- 1 pt   Task detail page gets title from the button that was tapped on the homepage
- 1 pt   Settings page exists & is reachable from homepage
- 1 pt   Saving username on settings page means it is displayed on homepage forevermore
- 1 pt   General functionality & usability
- 1 pt   README with description, screenshots, and daily change log
