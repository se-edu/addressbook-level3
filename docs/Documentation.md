---
layout: page
title: Documentation guide
---

**Setting up and maintaining the project website:**

* We use [**Jekyll**](https://jekyllrb.com/) to manage documentation.
* The `docs/` folder is used for documentation.
* To learn how set it up and maintain the project website, follow the guide [_[se-edu/guides] **Using Jekyll for project documentation**_](https://se-education.org/guides/tutorials/jekyll.html).
* Note these points when adapting the documentation to a different project/product:
  * The 'Site-wide settings' section of the page linked above has information on how to update site-wide elements such as the top navigation bar.
  * :bulb: In addition to updating content files, you might have to update the config files `docs\_config.yml` and `docs\_sass\minima\_base.scss` (which contains a reference to `AB-3` that comes into play when converting documentation pages to PDF format).
* If you are using Intellij for editing documentation files, you can consider enabling 'soft wrapping' for `*.md` files, as explained in [_[se-edu/guides] **Intellij IDEA: Useful settings**_](https://se-education.org/guides/tutorials/intellijUsefulSettings.html#enabling-soft-wrapping)


**Style guidance:**

* Follow the [**_Google developer documentation style guide_**](https://developers.google.com/style).

* Also relevant is the [_[se-edu/guides] **Markdown coding standard**_](https://se-education.org/guides/conventions/markdown.html)

**Diagrams:**

* See the [_[se-edu/guides] **Using PlantUML**_](https://se-education.org/guides/tutorials/plantUml.html)

**Converting a document to the PDF format:**

* See the guide [_[se-edu/guides] **Saving web documents as PDF files**_](https://se-education.org/guides/tutorials/savingPdf.html)
