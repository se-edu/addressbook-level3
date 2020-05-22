---
layout: page
title: DevOps Guide
---

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Build automation

This project uses Gradle for **build automation and dependency management**. See [Using Gradle](UsingGradle.md) for more details.

--------------------------------------------------------------------------------------------------------------------

## Continuous integration (CI)

This project uses GitHub Actions for CI. The project comes with the necessary GitHub Actions configurations files (in the `.github/workflows` folder). No further setting up required.

--------------------------------------------------------------------------------------------------------------------

## Making a release

Here are the steps to create a new release.

1. Update the version number in [`MainApp.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java).
1. Generate a JAR file [Using Gradle](UsingGradle.md#creating-the-jar-file).
1. Tag the repo with the version number. e.g. `v0.1`
1. [Create a new release using GitHub](https://help.github.com/articles/creating-releases/) and upload the JAR file you created.
