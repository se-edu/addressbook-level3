---
layout: page
title: Running Tests
---

There are two ways to run tests.

**Method 1: Using IntelliJ JUnit test runner**

  - To run all tests, right-click on the `src/test/java` folder and
    choose `Run 'All Tests'`

  - To run a subset of tests, you can right-click on a test package,
    test class, or a test and choose `Run 'ABC'`

**Method 2: Using Gradle**

  - Open a console and run the command `gradlew clean test` (Mac/Linux:
    `./gradlew clean test`)

{%include note.html content = "See [Using Gradle](UsingGradle.md) for more info on how to run
tests using Gradle." %}

## Types of tests

We have three types of tests:

1.  *Unit tests* targeting the lowest level methods/classes.  
    e.g. `seedu.address.commons.StringUtilTest`

2.  *Integration tests* that are checking the integration of multiple
    code units (those code units are assumed to be working).  
    e.g. `seedu.address.storage.StorageManagerTest`

3.  Hybrids of unit and integration tests. These test are checking
    multiple code units as well as how the are connected together.  
    e.g. `seedu.address.logic.LogicManagerTest`

## Troubleshooting Testing

**Problem: Keyboard and mouse movements are not simulated on macOS
Mojave, resulting in GUI Tests failure.**

  - Reason: From macOS Mojave onwards, applications without
    `Accessibility` permission cannot simulate certain keyboard and
    mouse movements.

  - Solution: Open `System Preferences`, click `Security and Privacy` →
    `Privacy` → `Accessibility`, and check the box beside `Intellij
    IDEA`.

![`Accessibility` permission is granted to `IntelliJ
IDEA`](images/testfx-idea-accessibility-permissions.png)
