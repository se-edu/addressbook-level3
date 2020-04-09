---
layout: page
title: Using Travis
---

{%include note.html content = "This document was originally written for *AddressBook Level 4* and hence
its screenshots refer to `addressbook-level4`. For use with *AddressBook
Level 3*, wherever `addressbook-level4` is used in the screenshots, you
should use **`addressbook-level3`**." %}

[Travis CI](https://travis-ci.org/) is a *Continuous Integration*
platform for GitHub projects.

Travis CI can run the projects' tests automatically whenever new code is
pushed to the repo. This ensures that existing functionality and
features have not been broken by the changes.

The current Travis CI set up performs the following things whenever
someone push code to the repo:

  - Runs the `./gradlew clean test coverage coveralls -i` command (see
    [Using Gradle](UsingGradle.md) for more details on what this command
    means).

  - Renders documentation from asciidoc to html and automatically
    publishes them using GitHub Pages.

  - Runs additional [repository-wide checks](#repository-wide-checks).

If you would like to customise your travis build further, you can learn
more about Travis from [Travis CI
Documentation](https://docs.travis-ci.com/).

## Setting up Travis CI

1.  Fork the repo to your own organization.

2.  Go to <https://travis-ci.org/> and click `Sign in with GitHub`, then
    enter your GitHub account details if needed.
    
    ![Signing into Travis CI](images/signing_in.png)

3.  Head to the [Accounts](https://travis-ci.org/profile) page, and find
    the switch for the forked repository.
    
      - If the organization is not shown, click `Review and add` as
        shown below:
        
        ![Review and add](images/review_and_add.png)
        
        This should bring you to a GitHub page that manages the access
        of third-party applications. Depending on whether you are the
        owner of the repository, you can either grant access
        
        ![Grant Access](images/grant_access.png)
        
        or request access
        
        ![Request Access](images/request_access.png)
        
        to Travis CI so that it can access your commits and build your
        code.
    
      - If repository cannot be found, click `Sync account`

4.  Activate the switch.
    
    ![Activate the switch](images/flick_repository_switch.png)

5.  This repo comes with a `.travis.yml` that tells
    Travis what to do. So there is no need for you to create one
    yourself.

6.  To see the CI in action, push a commit to the master branch\!
    
      - Go to the repository and see the pushed commit. There should be
        an icon which will link you to the Travis build.
        
        ![Commit build](images/build_pending.png)
    
      - As the build is run on a provided remote machine, we can only
        examine the logs it produces:
        
        ![Travis build](images/travis_build.png)

7.  If the build is successful, you should be able to check the coverage
    details of the tests at [Coveralls](http://coveralls.io/)

8.  Update the link to the 'build status' badge at the top of the
    `README.md` to point to the build status of your own repo.

## Enabling auto-publishing of documentation

1.  Ensure that you have followed the steps above to set up Travis CI.

2.  On GitHub, create a new user account and give this account
    collaborator and admin access to the repo.  
    Using this account, generate a personal access token
    [here](https://github.com/settings/tokens/new).
    
    {%include note.html content = "Personal access tokens are like passwords so make sure you keep them
    secret\! If the personal access token is leaked, please delete it
    and generate a new one." %}
    
    {%include note.html content = "We use a new user account to generate the token for team projects to
    prevent team members from gaining access to other team members'
    repos.  
    If you are the only one with write access to the repo, you can use
    your own account to generate the token." %}
    
      - Add a description for the token. (e.g. `Travis CI - deploy docs
        to gh-pages`)
    
      - Check the `public_repo` checkbox.
    
      - Click `Generate Token` and copy your new personal access token.
    
    We will use this token to grant Travis access to the repo.
    
    ![Generate token](images/generate_token.png)

3.  Head to the [Accounts](https://travis-ci.org/profile) page, and find
    the switch for the forked repository.
    
    ![Activate the switch](images/flick_repository_switch.png)

4.  Click on the settings button next to the switch. In the Environment
    Variables section, add a new environment variable with
    
      - name: `GITHUB_TOKEN`
    
      - value: personal access token copied in step 1
    
      - Display value in build log: `OFF`
    
    ![Travis add token](images/travis_add_token.png)
    
    {%include note.html content = "**Make sure you set `Display value in build log` to `OFF`.**  
    Otherwise, other people will be able to see the personal access
    token and thus have access this repo.  
    Similarly, make sure you **do not print `$GITHUB_TOKEN` to the
    logs** in Travis scripts as the logs are viewable by the public." %}

5.  Now, whenever there’s a new commit to master branch, Travis will
    push the latest documentation to gh-pages branch.

**To verify that it works,**

1.  Trigger Travis to regenerate documentation. To do so, you need to
    push a new commit to the master branch of the fork.  
    Suggested change: Remove the codacy badge from `README`.

2.  Wait for Travis CI to finish running the build on your new commit.

3.  Go to the URL
    `https://<your-username-or-organization-name>.github.io/addressbook-level3/`.
    You should see your `README` file displayed.

## Repository-wide checks

In addition to running Gradle checks, we also configure Travis CI to run
some repository-wide checks. Unlike the Gradle checks which only cover
files used in the build process, these repository-wide checks cover
*all* files in the repository. They check for repository rules which are
hard to enforce on development machines such as line ending
requirements.

These checks are implemented as POSIX shell scripts, and thus can only
be run on POSIX-compliant operating systems such as macOS and Linux. To
run all checks locally on these operating systems, execute the following
in the repository root directory:

``` shell
./config/travis/run-checks.sh
```

Any warnings or errors will be printed out to the console.

### Implementing new checks

Checks are implemented as executable `check-*` scripts within the
`config/travis/` directory. The `run-checks.sh` script will
automatically pick up and run files named as such.

Check scripts should print out errors in the following format:

    SEVERITY:FILENAME:LINE: MESSAGE

where `SEVERITY` is either `ERROR` or `WARN`, `FILENAME` is the path to
the file relative to the current directory, `LINE` is the line of the
file where the error occurred and `MESSAGE` is the message explaining
the error.

Check scripts must exit with a non-zero exit code if any errors occur.
