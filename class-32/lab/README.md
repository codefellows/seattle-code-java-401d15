# Integrating AWS for Cloud Data Storage

## Overview

Today, your app will gain a scalable backend by using AWS Amplify. We'll continue to work with Amplify to add more cloud functionality for the rest of the course.

## Setup

Continue working in your `taskmaster` repository. Ensure that you have [created an AWS account and installed the Amplify CLI](https://aws-amplify.github.io/docs/){:_target="blank"}, and follow the [Amplify Getting Started](https://docs.amplify.aws/lib/project-setup/prereq/q/platform/android/){:_target="blank"} directions to set up your application with Amplify.

## Resources

* [Amplify Getting Started](https://docs.amplify.aws/lib/project-setup/prereq/q/platform/android/){:_target="blank"}

## Feature Tasks

### Tasks Are Cloudy

Using the `amplify add api` command, create a Task resource that replicates our existing Task schema. Update all references to the Task data to instead use AWS Amplify to access your data in DynamoDB instead of in Room.

### Add Task Form

Modify your Add Task form to save the data entered in as a Task to DynamoDB.

### Homepage

Refactor your homepage's RecyclerView to display all Task entities in DynamoDB.

## Documentation

Update your daily change log with today's changes.

## Testing

Ensure that all Espresso tests are still passing (since we haven't changed anything about the UI today, no new updates required).

## Submission Instructions

* Continue working in your `taskmaster` repo.
* Work on a non-master branch and make commits appropriately.
* Update your README with your changes for today and screenshot of your work.
* Create a pull request to your master branch with your work for this lab.
* Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.

## Grading Rubric

* 1 pt   Amplify added to application
* 2 pts  Amplify client created in Application class
* 2 pts  Data is posted and displayed based on DynamoDB status, not local DB status
* 1 pt   README with description, screenshots, and daily change log
