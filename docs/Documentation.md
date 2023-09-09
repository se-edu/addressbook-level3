<frontmatter>
  layout: default.md
  title: "Documentation guide"
  pageNav: 3
  pageNavTitle: "Table Of Content"
</frontmatter>

# Documentation guide

**Setting up and maintaining the project website:**

* We use [**MarkBind**](https://markbind.org/) to manage documentation.
* The `docs/` folder is contains the source files for the documentation website.
* To learn how set it up and maintain the project website, read the following sections.
  * To find out more, go to the [_**MarkBind User Guide**_](https://markbind.org/userGuide/gettingStarted.html).


<panel header="##### Getting Started :rocket:" expanded>

++**Introduction**++

<div class="indented">

[**MarkBind**](https://markbind.org/) is a tool for generating static websites from markdown-like text, particularly suitable for text-heavy websites such as software project documentation.
</div>

++**Prerequisites**++

<div class="indented">

  * a basic knowledge of [Markdown](https://www.markdownguide.org/basic-syntax/) and [HTML](https://www.w3schools.com/html/) syntax<br>
  * a basic knowledge of running CLI commands<br>
</div>

++**Installation**++

<div class="indented">

  * install Java 8 or higher
  * install [Node.js](https://nodejs.org) 16 or higher
  * install [Graphviz](https://graphviz.org/download/) (for generating diagrams)
    * For Mac, you can use [Homebrew](https://brew.sh/) to install Graphviz: `brew install graphviz`
    * For Windows, you can use [Chocolatey](https://chocolatey.org/install) to install Graphviz: `choco install graphviz`
    * For Linux, you can use your package manager to install Graphviz: `sudo apt install graphviz`
  * open the project and go to the docs folder: `cd docs`
  * install dependencies, only needed once when setting up the project: `npm ci`
</div>


++**Updating Documents**++

<div class="indented">

  <box type="info" light>

  MarkBind is a superset of Markdown. Refer the [MarkBind user guide](https://markbind.org/userGuide/gettingStarted.html) for more details.
  </box>

  **First, start the _live preview_**: Unless it is a trivial change, you would want to see how your change to the documentation source files will reflect in the generated website. You can use the MarkBind _live preview_ mode to preview the generated website as you update the source file. To start the live preview mode,
  1. Open a command prompt.
  1. Navigate to the the _documentation root_ (in most projects, the documentation root is `[project root]/docs` -- if you are not sure, look for the folder containing the `site.json` file).
  1. Run the `npm run serve` command. That will open the generated website in your default browser.
  1. In the browser, navigate to the page you want to modify.

  **Next, edit the files you want**:
  1. Edit the source files (usually, `.md` files).
  1. When you save the file, the live preview will update to reflect the new contents (after a few seconds).

  <box type="warning" seamless>

  While _live preview_ can pick up most changes, it may not be able to pick up certain changes (e.g., changes to files in the `_markbind` folder or changes to nunjucks macros). Furthermore, some syntax errors in your code can cause the live preview to crash. In those cases, just stop the server (<kbd>Ctrl</kbd>+<kbd>C</kbd> on Windows) and start it again.
  </box>

</div>

++**Automating Deployments**++

<div class="indented">

  The docs site can be deployed automatically with GitHub Actions. The `.github/workflows/docs.yml` file provides a ready made script to achieve it. More info [here](https://markbind.org/userGuide/deployingTheSite.html#deploying-via-github-actions).
</div>

</panel>

* Note these points when adapting the documentation to a different project/product:
  * The [_markbind/tweaking the page structure_](https://markbind.org/userGuide/tweakingThePageStructure.html) and [_markbind/site.json_](https://markbind.org/userGuide/siteJsonFile.html) pages have information on how to update site-wide elements such as the top navigation bar.
  * :bulb: In addition to updating content files, you might have to update the config files `docs\site.json` and the layout files `docs\_markbind\layouts\default.md` (which contains a reference to `AB-3` that comes into play when converting documentation pages to PDF format).
* If you are using Intellij for editing documentation files, you can consider enabling 'soft wrapping' for `*.md` files, as explained in [_se-edu/guides **Intellij IDEA: Useful settings**_](https://se-education.org/guides/tutorials/intellijUsefulSettings.html#enabling-soft-wrapping)


**Style guidance:**

* Follow the [**_Google developer documentation style guide_**](https://developers.google.com/style).

* Also relevant is the [_se-edu/guides **Markdown coding standard**_](https://se-education.org/guides/conventions/markdown.html)

**Diagrams:**

* See the [_markbind/user-guide/diagrams **Using PlantUML with MarkBind**_](https://markbind.org/userGuide/components/imagesAndDiagrams.html#diagrams)

* See the [_se-edu/guides **Using PlantUML**_](https://se-education.org/guides/tutorials/plantUml.html)

**Converting a document to the PDF format:**

* See the guide [_se-edu/guides **Saving web documents as PDF files**_](https://se-education.org/guides/tutorials/savingPdf.html)
