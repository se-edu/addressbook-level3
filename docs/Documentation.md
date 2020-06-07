---
layout: page
title: Documentation
---

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Style guidance

Follow the [**Google developer documentation style guide**](https://developers.google.com/style).

--------------------------------------------------------------------------------------------------------------------

## Publishing documentation

We use [**Jekyll**](https://jekyllrb.com/) to manage documentation. As GitHub has native support for Jekyll, it can convert your documentation into HTML and deploy it on the `githhub.io` URL of your project.

Do the following to set up the GitHub pages website of your project:
1. Go to your repo's `settings` tab.
1. Scroll down to the `GitHub Pages` section.
1. Set the `Source` to `master branch /docs folder`.

--------------------------------------------------------------------------------------------------------------------

## Updating contents

Jekyll uses [**kramdown**](https://kramdown.gettalong.org/syntax.html) (a superset of Markdown) for writing content. You can use Intellij (or any other text editor) to update the relevant `.md` files. 

<div markdown="span" class="alert alert-success">:bulb: **Recommendation:** Limit your content to Markdown and GFMD syntax only i.e., avoid kramdown-specific syntax that are not compatible with Markdown/GFMD

</div>

* **Editing diagrams**: See [_PlantUML Tutorial_ at se-edu/guides](https://se-education.org/guides/tutorials/plantUml.html) to find out how to create and update the UML diagrams in the developer guide.
* **Previewing changes locally**: There are several ways to preview changes locally.
  * **Option 1 -- Intellij preview**: Intellij supports previewing Markdown files, as explained [here](https://www.jetbrains.com/help/idea/markdown.html). While the preview shown by Intellij is somewhat rudimentary, it is good enough for most cases.
  * **Option 2 -- Run Jekyll locally**: You can [set up Jekyll locally and run it](https://help.github.com/en/github/working-with-github-pages/testing-your-github-pages-site-locally-with-jekyll) to see the exact way the update affects the final outcome.
* **Previewing changes on GitHub**:
  * **Option 1 -- Github preview**: You can see a basic preview of the page by navigating to the corresponding `.md` source file in GitHub.
  * **Option 2 -- Use Netlify PR preview**: You can set up Netlify to show previews of PRs (to learn how, read the [_Netlify Tutorial_ at se-edu/guides](https://se-education.org/guides/tutorials/netlify.html). This method shows a preview of the exact way the update affects the final outcome. However, note that Netlify has a limit on monthly build minutes, likely insufficient for an active project.

--------------------------------------------------------------------------------------------------------------------

## Site-wide documentation settings
The `_config.yml` file specifies some project-specific attributes which affect all the documentation within this project.

|Attribute|Description|
|---------|-----------|
|`title`|The title of your site, usually the name of your project.|

The files in `docs/_include` and `docs/_layouts` control the template of the pages; the files in `docs/_sass` control the style of the pages.

<div markdown="span" class="alert alert-warning">:warning: **Warning:**

Modifying these files requires some knowledge and experience with Jekyll. You should only modify them if you need greater control over the site’s layout. The SE-EDU team does not provide support for modified template files.
</div>

--------------------------------------------------------------------------------------------------------------------

## Converting a document to the PDF format

**Use [Google Chrome](https://www.google.com/chrome/browser/desktop/) (:exclamation: NOT any other Browser)** for converting documentation to PDF format. Reason: Chrome’s PDF engine preserves hyperlinks used in Web pages.

Here are the steps to convert the project documentation files to PDF format.
1. Go to your generated documentation site on GitHub using Chrome.
1. Within Chrome, click on the `Print` option in Chrome’s menu.
1. Set the destination to `Save as PDF`, then click `Save` to save a copy of the file in PDF format. For best results, use the settings indicated in the screenshot below.

![Saving documentation as PDF files in Chrome](images/chrome_save_as_pdf.png)

