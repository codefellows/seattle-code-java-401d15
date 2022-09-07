# Bitmap Transformer

## Overview
In this paired lab, you will work with a partner to build a bitmap transformer CLI.

## Resources
* [Bitmap Specification](https://en.wikipedia.org/wiki/BMP_file_format){:target="_blank"}

## Setup
Create a new repo called `bitmap-transformer` for this paired lab, and ensure you've added your partner as a collaborator. Create a new Java application by running `gradle init --type java-application`.

## Feature Tasks
For this assignment you will be building a bitmap (`.bmp`) transformer CLI. It
will read a bitmap in from disk, run one or more color or raster transforms and
then write it out to a new file. This project will require manipulating binary
data. Your solution should be composed of small tested methods that solve
specific problems. Your methods should be thoughtfully named and well
documented. You should run `./gradlew run --args 'input output transform'` to run your application. Your
bitmap transformer modules should not use any third party libraries.

#### Minimum Requirements
* The CLI should be architected using best modularization practices.
* The CLI should contain a `Bitmap` class, and reading in a file should create a new `Bitmap` instance.
* The CLI should require at least three arguments: `input-file-path output-file-path transform-name`.
* The CLI should support a minimum of three transforms, each of which is an instance method in the `Bitmap` class.
* The CLI should log useful Error messages if used incorrectly.
* The CLI should log a success message on completion.

## Testing
* Use JUnit to define descriptive tests.
* Each `@Test` method should aim to test a small well defined feature of a function.
* Write tests to ensure each function behaves correctly with valid and invalid inputs.

### Tips
You will want to define a strategy for solving the problem before you begin to
code. Once you have a strategy defined, you can break it into steps that can be
split into helper methods. Each helper method should solve a small specific
problem. The main method should utilize the helper modules to execute your
original strategy.

###### Example Strategy
0. Gather user input (infile, outfile, and transform)
0. Read the input bitmap file
0. Parse the bitmap's data into a Bitmap object (instance of a Bitmap class that you write)
0. Using data from the parsed Bitmap, run a transform on the data
   directly (mutate the color or similar)
0. Write the mutated image data to the output file path

###### Transform Ideas
* Color Pallet Transforms
  * Invert
  * Randomize
  * Black and White
  * Darken or Lighten
  * Add or Multiply a Hue
  * Add or Subtract Contrast

* Raster Data Transforms
  * Pixelate
  * Add a border
  * Add a watermark
  * Rotate
  * Vertically or Horizontally Mirror
  * Vertically or Horizontally Stretch

## Documentation
Describe the transforms your program supports in `README.md`.

## Stretch Goals
* Implement more transforms!

## Submission Instructions
* Work with a partner in the new repo you created for this lab.
* Work on a non-master branch and make commits appropriately.
* In your README file, include several examples of how your grader can run your code and see outputs.
* Ensure that you can test your bitmap transformer on a variety of files by running `./gradlew test`.
* Create a pull request to your master branch with your work for this lab.
* Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.

## Grading Rubric
- 1 pt for running from the command line
- 1 pt for reading/writing a bitmap file
- 1 pt for having 3 transforms
- 1 pt for logging useful messages about the progress of the transformer while running
- 1 pt for having some tests
- 1 pt for README
