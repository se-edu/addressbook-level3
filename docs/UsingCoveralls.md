---
layout: page
title: Using Coveralls
---

<div markdown="span" class="alert alert-info">:information_source: <b>Note: </b>

This document was originally written for *AddressBook Level 4* and hence
its screenshots refer to `addressbook-level4`. For use with *AddressBook
Level 3*, wherever `addressbook-level4` is used in the screenshots, you
should use **`addressbook-level3`**.
</div>

[Coveralls](https://coveralls.io/) is a web service that tracks code
coverage over time for GitHub projects. Coveralls requires Travis CI to
be set up beforehand as Travis sends the coverage report from the latest
build to Coveralls. If you have not set up Travis CI, see
[using Travis](UsingTravis.md). Currently, Coveralls supports
Travis CI but not AppVeyor.

## Setting up Coveralls

1.  Go to <https://coveralls.io/> and click `SIGN IN`. Then click
    `GITHUB SIGN IN` and enter your GitHub account details if needed.

2.  After logging in, you will be brought to the `Your Repositories`
    page. On the site’s navigation bar, click [ADD
    REPOS](https://coveralls.io/repos/new).

3.  Find the switch for the forked repository.

      - If the organization is not shown, click `GITHUB SETTINGS` as
        shown below:

        ![GitHub settings](images/coveralls/github_settings.png)

        This should bring you to a GitHub page that manages the access
        of third-party applications. Depending on whether you are the
        owner of the repository, you can either grant access

        ![Grant Access](images/grant_access.png)

        or request access

        ![Request Access](images/request_access.png)

        to Coveralls so that it can access your repository.

      - If your repository cannot be found, click `SYNC REPOS`.

        ![Sync repos](images/coveralls/sync_repos.png)

4.  Activate the switch.

    ![Activate the switch](images/coveralls/flick_repository_switch.png)

5.  Update the link of the `Coverage Status` badge at the top of your
    `README.md` to point to that of your own repo by
    replacing the outlined areas with `your-org-name/your-repo-name`.

    ![Coverage Status
    Badge](images/coveralls/coverage_asciidoc_code.png)

6.  You can now see the coverage report for your project after each
    Travis build by clicking on the `Coverage Status` badge.

    ![Coverage Report Summary](images/coveralls/coverage_report.png)

## Disabling Coveralls Automatic Comments on Pull Requests

Coveralls automatically comments on the coverage status of the pull
requests in GitHub. If it’s a hindrance, you can disable it in the
settings of your project in Coveralls:

1.  Click `Settings`.

2.  Uncheck the `LEAVE COMMENTS?` checkbox. Then click `SAVE CHANGES`.

    ![Disable comments](images/coveralls/disable_comments.png)
