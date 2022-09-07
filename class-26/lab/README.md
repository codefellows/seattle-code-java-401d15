# Beginning TaskMaster

## Overview

Today, you'll start building an Android app that will be a main focus of the second half of the course: TaskMaster. While you'll start small today, over time this will grow to be a fully-featured application.

## Setup

To start, create a new directory and repo to hold this app. Name it `taskmaster`. Within that directory, use Android Studio to set up a new app, as discussed in class. Create a README file that includes, at minimum, a description of your app and a daily change log.

## Resources

* [Android Buttons](https://developer.android.com/guide/topics/ui/controls/button.html){:_target="blank"}
* [Android UI Events](https://developer.android.com/guide/topics/ui/ui-events.html){:_target="blank"}

## Feature Tasks

### Homepage  

The main page should be built out to match the [wireframe](../taskmaster_homepage.png){:_target="blank"}. In particular, it should have a heading at the top of the page, an image to mock the "my tasks" view, and buttons at the bottom of the page to allow going to the "add tasks" and "all tasks" page.

### Add a Task

On the ["Add a Task" page](../taskmaster_add_task.png){:_target="blank"}, allow users to type in details about a new task, specifically a title and a body. When users click the "submit" button, show a "submitted!" label on the page.

### All Tasks

The [all tasks page](../taskmaster_all_tasks.png){:_target="blank"} should just be an image with a back button; it needs no functionality.

## Documentation

Create a directory called `screenshots` in the root of your project. Take a
screenshot of the homepage you've created. Use markdown to render the screenshot
in your README.

For reference, here's the markdown syntax to render an image in a page:

```markdown
![image description](screenshots/path_to_screenshot_file.png)
```

## Testing

In a future lecture, we'll talk about how to test Android UI using Espresso. For now, ensure that you're writing good unit tests for anything unit-testable in your code.

## Stretch Goals

* Consider the styling for this app. Decide on a color scheme and font families to use. (You'll thank yourself later for doing this work now!)

## Submission Instructions

* Work in your new `taskmaster` repo.
* Work on a non-master branch and make commits appropriately.
* Update your README with your changes for today and screenshot of your work.
* Create a pull request to your master branch with your work for this lab.
* Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.

## Grading Rubric

* 2 pts  Android application with 3 basic pages
* 2 pts  Form that displays a message on the "add task" page
* 1 pts  Overall functionality, lack of bugs
* 1 pts  README with description, screenshots, and daily change log
