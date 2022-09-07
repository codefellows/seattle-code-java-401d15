# Analytics and Text To Speech (Amplify Predictions)

## Overview

Today, your app will start collecting basic, aggregated analytics on user usage, and will also read task descriptions to users out loud.

## Setup

Continue working in your `taskmaster` repository.

## Resources

* [Amplify Getting Started With Analytics](https://docs.amplify.aws/lib/analytics/getting-started/q/platform/android/) {:_target="blank"}
* [Amplify Getting Started With Predictions](https://docs.amplify.aws/lib/predictions/getting-started/q/platform/android/) {:_target="blank"}
* [Amplify Text To Speech](https://docs.amplify.aws/lib/predictions/text-speech/q/platform/android/) {:_target="blank"}

## Feature Tasks

### Analytics

On the "Main" activity (and any other activities you like), start recording at least one AnalyticsEvent. Make sure you can view instances of that event, including their custom properties, in Amazon Pinpoint.

### Text To Speech

On the Task Detail activity, add a button to read out the task's description using the Amplify Predictions library.

### Second Predictions Integration

Somewhere in your application, integrate one of the other Amplify Predictions APIs. See the possibilities at https://docs.amplify.aws/lib/predictions/getting-started/q/platform/android/#next-steps .

## Documentation

Update your daily change log with today's changes. Include a screenshot of the Amazon Pinpoint dashboard with your events and at least one custom property visible.

## Submission Instructions

* Continue working in your `taskmaster` repo.
* Work on a non-master branch and make commits appropriately.
* Update your README with your changes for today and screenshot of your work.
* Create a pull request to your master branch with your work for this lab.
* Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.

## Grading Rubric

* 1 pt   Add analytics event to your app
* 1 pt   Add a screenshot of your analytics dashboard
* 2 pts  Add a button to read out your task description
* 1 pt   Add another Predictions integration to your application
* 1 pt   README with description, screenshot, and daily change log
