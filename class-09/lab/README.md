# Potent Quotables

## Overview
Today you'll update your lab from yesterday: rather than using a hardcoded file of JSON data with quotes, you'll grab quotes from an API and display those to the user.

## Setup
Continue building on your work from lab 8. If your partner was the one who created the repo in that lab, create a fork of their repo and clone that fork to hold your work for today. (If you had already created your own fork, make a PR from the base fork to your fork to ensure you have all of your work from yesterday, and then pull your repo.)

## Feature Tasks
- Start by refactoring anything that you don't like about your solution from yesterday.
- When running the application, don't read in the quotes file. Instead, make a request to an API to get a random quote.
    - please do not delete your existing code, look at the very next feature task, you will still need that code
    - Some examples of APIs you could choose to use:
        - [FavQs](https://favqs.com/api){:target="_blank"}: sign up for a free API key (takes 2 minutes) to get random quotes
        - [Formismatic](http://formismatic.com/en/api){:target="_blank"}: no API key required, visit `http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en` to get random quotes
        - [Star Wars Quotes API](http://swquotesapi.digitaljedi.dk/index.html){:target="_blank"}
        - [Ron Swanson Quotes](https://github.com/jamesseanwright/ron-swanson-quotes#ron-swanson-quotes-api){:target="_blank"}
    - Rather than a Quote of the Day, please use an API that allows you to show a random quote.
- We do still have this quotes file, though, and it might still be useful! Ensure that if your app has errors in connecting to the Internet, you instead display a random quote from your file.
- When we grab a random quote from the Internet, we could add it to our file of quotes, for use if the app goes offline in the future. Add that functionality: when a quote comes back from a request, it's also cached in the json file.

## Stretch Goals
- Allow the user to specify, with a command-line parameter, whether they want a local quote or an internet quote.

## Submission Instructions
* Continue working in your repo from yesterday (or make a fork if needed).
* Work on a non-master branch and make commits appropriately.
* In your README file, include directions for how your grader can run your code and see outputs.
* Ensure that you can test your code by running `./gradlew test`.
* Create a pull request to your master branch with your work for this lab.
* Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.

## Grading Rubric
- 1 pt show random quotes in terminal from API
- 1 pt show random quotes in terminal from file when internet connectivity is down
- 1 pt for appending API quote to JSON file
- 2 pts for tests passing in terminal and IDE
- 1 pt for README with clear instructions on how to run application
