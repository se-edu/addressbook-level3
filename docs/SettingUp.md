---
layout: page
title: Setting Up
---

## Prerequisites

1.  **JDK `11`** or above

2.  **IntelliJ** IDE

<div markdown="span" class="alert alert-info">:information_source: <b>Note: </b>

IntelliJ by default has Gradle and JavaFx
plugins installed.  Do not disable them. If you have disabled them, go
to `File` \> `Settings` \> `Plugins` to re-enable them.
</div>

## Setting up the project in your computer

1.  Fork this repo, and clone the fork to your computer

2.  Open IntelliJ (if you are not in the welcome screen, click `File` \>
    `Close Project` to close the existing project dialog first)

3.  Set up the correct JDK version for Gradle

    1.  Click `Configure` \> `Project Defaults` \> `Project Structure`

    2.  Click `New…​` and find the directory of the JDK

4.  Click `Import Project`

5.  Locate the `build.gradle` file and select it. Click `OK`

6.  Click `Open as Project`

7.  Click `OK` to accept the default settings.

## Verifying the setup

1.  Run the `seedu.address.Main` and try a few commands

2.  [Run the tests](Testing.md) to ensure they all pass.

## Configurations to do before writing code

### Configuring the coding style

This project follows [oss-generic coding
standards](https://oss-generic.github.io/process/docs/CodingStandards.html).
IntelliJ’s default style is mostly compliant with ours but it uses a
different import order from ours. To rectify,

1.  Go to `File` \> `Settings…​` (Windows/Linux), or `IntelliJ IDEA` \>
    `Preferences…​` (macOS)

2.  Select `Editor` \> `Code Style` \> `Java`

3.  Click on the `Imports` tab to set the order

      - For `Class count to use import with '*'` and `Names count to use
        static import with '*'`: Set to `999` to prevent IntelliJ from
        contracting the import statements

      - For `Import Layout`: The order is `import static all other
        imports`, `import java.*`, `import javax.*`, `import org.*`,
        `import com.*`, `import all other imports`. Add a `<blank line>`
        between each `import`

Optionally, you can follow the
[Using Checkstyle](UsingCheckstyle.md) document to configure
Intellij to check style-compliance as you write code.

### Updating documentation to match your fork

After forking the repo, the documentation will still refer to the 
`se-edu/addressbook-level3` repo.

If you plan to develop this fork as a separate product (i.e. instead of
contributing to `se-edu/addressbook-level3`), you should configure the
site-wide documentation to suit your own project.

The configuration file can be found at `docs/_config.yml`. Change the
`title` to your project's title.

### Setting up CI

Set up Travis to perform Continuous Integration (CI) for your fork. See
[Using Travis](UsingTravis.md) to learn how to set it up.

After setting up Travis, you can optionally set up coverage reporting
for your team fork (see [Using Coveralls](UsingCoveralls.md)).

<div markdown="span" class="alert alert-info">:information_source: <b>Note: </b>

Coverage reporting could be useful for a team repository that hosts the
final version but it is not that useful for your personal fork.
</div>

Optionally, you can set up AppVeyor as a second CI (see
[Using AppVeyor](UsingAppVeyor.md)).

<div markdown="span" class="alert alert-info">:information_source: <b>Note: </b>

Having both Travis and AppVeyor ensures your App works on both
Unix-based platforms and Windows-based platforms (Travis is Unix-based
and AppVeyor is Windows-based)
</div>

### Getting started with coding

When you are ready to start coding, we recommend that you get some sense
of the overall design by reading about [AddressBook’s architecture](DeveloperGuide.md).
