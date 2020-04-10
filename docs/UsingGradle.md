---
layout: page
title: Using Gradle
---

[Gradle](https://gradle.org/) is a build automation tool. It can
automate build-related tasks such as

  - Running tests

  - Managing library dependencies

  - Analyzing code for style compliance

The gradle configuration for this project is defined in the *build
script* [`build.gradle`](../build.gradle).

{%include note.html content = "To learn more about gradle build scripts, refer [Build Scripts
Basics](https://docs.gradle.org/current/userguide/tutorial_using_tasks.html)." %}

## Running Gradle Commands

To run a Gradle command, open a command window on the project folder and
enter the Gradle command. Gradle commands look like this:

  - On Windows: `gradlew <task1> <task2> …​` e.g. `gradlew clean test`

  - On Mac/Linux: `./gradlew <task1> <task2>…​` e.g. `./gradlew clean
    test`

{%include note.html content = "If you do not specify any tasks, Gradlew will run the default tasks
`clean` `test` `coverage`" %}

## Cleaning the Project

  - **`clean`**  
    Deletes the files created during the previous build tasks (e.g.
    files in the `build` folder). e.g. `./gradlew clean`

{%include tip.html content="**`clean` to force Gradle to execute a task**:  
When running a Gradle task, Gradle will try to figure out if the task
needs running at all. If Gradle determines that the output of the task
will be same as the previous time, it will not run the task. For
example, it will not build the JAR file again if the relevant source
files have not changed since the last time the JAR file was built. If we
want to force Gradle to run a task, we can combine that task with
`clean`. Once the build files have been `clean` ed, Gradle has no way to
determine if the output will be same as before, so it will be forced to
execute the task." %}

## Creating the JAR file

  - **`shadowJar`**  
    Creates the `addressbook.jar` file in the `build/jar` folder, *if
    the current file is outdated*.  
    e.g. `./gradlew shadowJar`

To force Gradle to create the JAR file even if the current one is
up-to-date, you can ‘clean’ first.  
e.g. `./gradlew clean shadowJar`

{%include note.html content = "**Why do we create a fat JAR?** If we package only our own class files
into the JAR file, it will not work properly unless the user has all the
other JAR files (i.e. third party libraries) our classes depend on,
which is rather inconvenient. Therefore, we package all dependencies
into a single JAR files, creating what is also known as a *fat* JAR
file. To create a fat JAR file, we use the Gradle plugin [shadow
jar](https://github.com/johnrengelman/shadow)." %}

## Rendering AsciiDoc files

  - **`asciidoctor`**  
    Converts AsciiDoc files in `docs` to HTML format. Generated HTML
    files can be found in `build/docs`.

  - **`deployOfflineDocs`**  
    Updates the offline user guide, and its associated files, used by
    the Help window in the application. Deployed HTML files and images
    can be found in `src/main/resources/docs`.

## Running the application

  - **`run`**  
    Builds and runs the application.

  - **`runShadow`**  
    Builds the application as a fat JAR, and then runs it.

## Running code style checks

  - **`checkstyleMain`**  
    Runs the code style check for the main code base

  - **`checkstyleTest`**  
    Runs the code style check for the test code base

The set of code style rules implemented can be found in
`config/checkstyle/checkstyle.xml`. To enable *exceptions* to code
styles, add in the comment `//CODESTYLE.OFF: RuleName` at the start of
the section and `//CODESTYLE.ON: RuleName` at the end of the section.

## Running Tests

  - **`test`**  
    Runs all tests.

Here are some examples:

  - `./gradlew test` — Runs all tests

  - `./gradlew clean test` — Cleans the project and runs tests

## Updating Dependencies

There is no need to run these Gradle tasks manually as they are called
automatically by other relevant Gradle tasks.

  - **`compileJava`**  
    Checks whether the project has the required dependencies to compile
    and run the main program, and download any missing dependencies
    before compiling the classes.  
    See `build.gradle` → `allprojects` → `dependencies` → `compile` for
    the list of dependencies required.

  - **`compileTestJava`**  
    Checks whether the project has the required dependencies to perform
    testing, and download any missing dependencies before compiling the
    test classes.  
    See `build.gradle` → `allprojects` → `dependencies` → `testCompile`
    for the list of dependencies required.
