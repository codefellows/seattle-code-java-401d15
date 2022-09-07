# Quotes

## Resources
* [GSON User Guide](https://github.com/google/gson/blob/master/UserGuide.md){:target="_blank"}

## Setup
Create a new repository for this partnered lab; call it `quotes`. In that repo, add a `.gitignore` file from the course repo, and then run `gradle init --type java-application`.

## Feature Tasks
Use the file [recentquotes.json](../recentquotes.json){:target="_blank"} to show random popular book quotes.
Your program should use [GSON](https://github.com/google/gson){:target="_blank"} to parse the .json file. The app needs no
functionality other than showing the quote and the author when it is run. The app should
choose one quote each time it is run.

### so what's interesting here?
The interesting parts of this lab are:
- How do I use `GSON`?
- What class(es) should I write to encapsulate this functionality?
- How does the `App` class use the class(es) I write?
- How do I test this functionality?

## Testing
* Use JUnit to write at least one test for each of the Feature Tasks.

## Documentation
* Provide a brief description of what the application does in `README.md`.
* Include clear instructions of how to install dependencies and run the
  app after someone clones the repo.

## Stretch Goals

Note that if you implement any of these stretch goals, you should also write tests for them!

* Allow users to type in an author (on the command line) and return a quote by that author.
* Allow users to type in a word (on the command line) and return a quote that contains that word.
* Allow both of those things at the same time, with two different command line args (for example, `./gradlew run --args "author Chimamanda"` vs `./gradlew run --args "contains work"`)

## Submission Instructions
* Work in your new `quotes` repository.
* Work on a non-master branch and make commits appropriately.
* In your README file, include specific directions for how your grader can run your code and see outputs.
* Ensure that you can test your code by running `./gradlew test`.
* Create a pull request to your master branch with your work for this lab.
* Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.

## Grading Rubric
- 3 pts show random quotes in terminal
- 2 pts for tests passing in terminal and IDE
- 1 pt for README with clear instructions on how to run application
