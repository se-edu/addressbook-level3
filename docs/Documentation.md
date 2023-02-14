<frontmatter>
  layout: default.md
  title: "Documentation guide"
  pageNav: 3
  pageNavTitle: "Table Of Content"
</frontmatter>

# Documentation guide

**Setting up and maintaining the project website:**

* We use [**MarkBind**](https://markbind.org/) to manage documentation.
* The `docs/` folder is used for documentation.
* To learn how set it up and maintain the project website, follow the [_**MarkBind User Guide**_](https://markbind.org/userGuide/gettingStarted.html).
  * Quick start:
    * `cd docs # go to the docs folder`
    * `npm i # install dependencies, only needed once when setting up the project`
    * `npm run serve # preview the website locally and make edits`
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
