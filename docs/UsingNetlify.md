---
layout: page
title: Using Netlify
---

{%include note.html content = "This document was originally written for *AddressBook Level 4* and hence
its screenshots refer to `addressbook-level4`. For use with *AddressBook
Level 3*, wherever `addressbook-level4` is used in the screenshots, you
should use **`addressbook-level3`**." %}

[Netlify](https://www.netlify.com/) is an automated hosting platform for
deploying static websites. With the aid of build tools such as Gradle,
Netlify provides a smoother experience for previewing documentation.
This can be done by using Netlify’s [Deploy
Previews](https://www.netlify.com/blog/2016/07/20/introducing-deploy-previews-in-netlify/)
feature, which shows a preview of the updated documentation whenever a
pull request is made.

## Setting up Netlify

1.  Fork the repository to your own organization.

2.  Go to <https://www.netlify.com/> and click `Sign Up`. Next, click
    `GITHUB SIGN IN`, enter your GitHub account details and authorize
    netlify.

3.  After logging in, click `New site from Git`.

4.  You will then be brought to the setup page. Click `GitHub` to link
    your repository to Netlify.

      - Depending on whether you are the owner of the repository, you
        can either grant or request access to Netlify so that it can
        access your repository and build your documentation.

        ![Grant or request
        access](images/netlify/grant_or_request_access.png)

      - After granting or requesting access to your repository, click
        `Authorize netlify`.

5.  Pick your repository from the list.

6.  Fill out the details as follows and then click `Deploy site`.

      - Branch to deploy: select `master` branch

      - Build command: `./gradlew asciidoctor`

        {%include note.html content = "The build command is the command that builds the documentation
        into HTML format." %}

      - Publish directory: `build/docs/html5`

        {%include note.html content = "The publish directory is the directory in which the built HTML
        documentation resides." %}

7.  Once Netlify has completed building your project, you can now:

      - View your main branch’s deployed documentation on the site name
        given by Netlify (customizable as shown
        [below](#_changing_the_site_name_of_your_project)).

        ![Temporary site name](images/netlify/temp_site_name.png)

      - Preview the updated documentation whenever a pull request is
        made by clicking the `Details` hyperlink next to the Netlify
        test status.

        ![Netlify details link](images/netlify/netlify_details.png)

## Changing the site name of your project

If you don’t like the site name given by Netlify, you can change it as
follows:

1.  Click on `Settings`.

2.  Then click `Change site name` and fill in your desired site name.

    ![Change site name](images/netlify/change_site_name.png)
