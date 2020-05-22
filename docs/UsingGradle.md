---
layout: page
title: Using Gradle
---


**If you are new to Gradle, please read [this Gradle Tutorial from the Duke project](https://github.com/se-edu/duke/blob/master/tutorials/gradleTutorial.md)**.


<div markdown="block" class="alert alert-info">

:information_source: **Reminder:** To run a Gradle command, open a command window on the project folder and enter the Gradle command. Gradle commands look like this:

* On Windows: `gradlew <task1> <task2> …​` e.g. `gradlew clean test`
* On Mac/Linux: `./gradlew <task1> <task2>…​` e.g. `./gradlew clean
    test`

</div>

Given below are how to use Gradle for some important project tasks.


* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------
## Cleaning the project

* **`clean`**: Deletes the files created during the previous build tasks (e.g. files in the `build` folder).<br>
  e.g. `./gradlew clean`

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** You can use **`clean` to prevent Gradle from skipping tasks**: When running a Gradle task, Gradle will try to figure out if the task needs running at all. If Gradle determines that the output of the task will be same as the previous time, it will not run the task. For example, it will not build the JAR file again if the relevant source files have not changed since the last time the JAR file was built. If you want to force Gradle to run a task, you can combine that task with `clean` (e.g., `./gradlew clean shadowJar`). Once the build files have been `clean` ed, Gradle has no way to determine if the output will be same as before, and it will have no choice but to execute the task.

</div>

## Creating the JAR file

* **`shadowJar`**: Uses the ShadowJar plugin to creat a fat JAR file in the `build/jar` folder, *if the current file is outdated*.<br>
  e.g. `./gradlew shadowJar`.

<div markdown="span" class="alert alert-info">

:information_source: **Note:** **What's a _fat_ JAR? Why do we need one?** If you package only your own class files into the JAR file, it will not work properly unless the user has all the other JAR files (i.e. third-party libraries) your classes depend on, which is rather inconvenient. Therefore, you should package all dependencies into a single JAR files, creating what is also known as a _fat_ JAR file. To create a fat JAR file, use the Gradle plugin [shadow jar](https://github.com/johnrengelman/shadow).
</div>

## Running the application

* **`run`**: Builds and runs the application.
* **`runShadow`**: Builds the application as a fat JAR, and then runs it.

## Running code style checks

* **`checkstyleMain`**: Runs the code style check for the main code base.
* **`checkstyleTest`**: Runs the code style check for the test code base.

The set of code style rules implemented can be found in `config/checkstyle/checkstyle.xml`. To enable *exceptions* to code styles, add in the comment `//CODESTYLE.OFF: RuleName` at the start of the section and `//CODESTYLE.ON: RuleName` at the end of the section.

## Running Tests

* **`test`**: Runs all tests.<br>
  Examples:
  * `./gradlew test` — Runs all tests
  * `./gradlew clean test` — Cleans the project and runs tests

## Compiling

There is no need to run these Gradle tasks manually as they are called automatically by other relevant Gradle tasks.

* **`compileJava`**: Checks whether the project has the required dependencies to compile and run the main program, and download any missing dependencies before compiling the classes. See `build.gradle` → `allprojects` → `dependencies` → `compile` for the list of dependencies required.
* **`compileTestJava`**: Checks whether the project has the required dependencies to perform testing, and download any missing dependencies before compiling the test classes. See `build.gradle` → `allprojects` → `dependencies` → `testCompile` for the list of dependencies required.
