---
layout: page
title: DevOps
---

## Build Automation

See [Using Gradle](UsingGradle.md) to learn how to use Gradle for
build automation.

## Continuous Integration

We use [Travis CI](https://travis-ci.org/) and
[AppVeyor](https://www.appveyor.com/) to perform *Continuous
Integration* on our projects. See [Using Travis](UsingTravis.md)
and [Using AppVeyor](UsingAppVeyor.md) for more details.

## Coverage Reporting

We use [Coveralls](https://coveralls.io/) to track the code coverage of
our projects. See [Using Coveralls](UsingCoveralls.md) for more
details.

## Documentation Previews

When a pull request has changes to asciidoc files, you can use
[Netlify](https://www.netlify.com/) to see a preview of how the HTML
version of those asciidoc files will look like when the pull request is
merged. See [Using Netlify](UsingNetlify.md) for more details.

## Making a Release

Here are the steps to create a new release.

1.  Update the version number in
    [`MainApp.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java).

2.  Generate a JAR file [Using
    Gradle](UsingGradle.md#creating-the-jar-file).

3.  Tag the repo with the version number. e.g. `v0.1`

4.  [Create a new release using
    GitHub](https://help.github.com/articles/creating-releases/) and
    upload the JAR file you created.

## Managing Dependencies

A project often depends on third-party libraries. For example, Address
Book depends on the [Jackson
library](https://github.com/FasterXML/jackson) for JSON parsing.
Managing these *dependencies* can be automated using Gradle. For
example, Gradle can download the dependencies automatically, which is
better than these alternatives:

1.  Include those libraries in the repo (this bloats the repo size)

2.  Require developers to download those libraries manually (this
    creates extra work for developers)
