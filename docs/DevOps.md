---
layout: page
title: DevOps Guide
---

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Build automation

This project uses Gradle for **build automation and dependency management**. **You are recommended to read [this Gradle Tutorial from the se-edu/guides](https://se-education.org/guides/tutorials/gradleTutorial.html)**.


Given below are how to use Gradle for some important project tasks.


* **`clean`**: Deletes the files created during the previous build tasks (e.g. files in the `build` folder).<br>
  e.g. `./gradlew clean`

* **`shadowJar`**: Uses the ShadowJar plugin to creat a fat JAR file in the `build/lib` folder, *if the current file is outdated*.<br>
  e.g. `./gradlew shadowJar`.

* **`run`**: Builds and runs the application.<br>
  **`runShadow`**: Builds the application as a fat JAR, and then runs it.

* **`checkstyleMain`**: Runs the code style check for the main code base.<br>
  **`checkstyleTest`**: Runs the code style check for the test code base.

* **`test`**: Runs all tests.<
  * `./gradlew test` — Runs all tests
  * `./gradlew clean test` — Cleans the project and runs tests

--------------------------------------------------------------------------------------------------------------------

## Continuous integration (CI)

This project uses GitHub Actions for CI. The project comes with the necessary GitHub Actions configurations files (in the `.github/workflows` folder). No further setting up required.

--------------------------------------------------------------------------------------------------------------------

## Making a release

Here are the steps to create a new release.

1. Update the version number in [`MainApp.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java).
1. Generate a fat JAR file using Gradle (i.e., `gradlew shadow`).
1. Tag the repo with the version number. e.g. `v0.1`
1. [Create a new release using GitHub](https://help.github.com/articles/creating-releases/). Upload the JAR file you created.
