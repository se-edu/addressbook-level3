---
layout: page
title: Documentation
---

We use `kramdown`, a flavor of `markdown` for writing documentation.

## Editing Diagrams

See [Using PlantUml](UsingPlantUml.md) to find out how to create
and update the UML diagrams in the developer guide.

## Publishing Documentation

1. Go to your organization's repository settings.
1. Set GitHub Pages to publish from your `master` branch `/docs folder`
through:`Options` > `Source` > `master branch /docs folder`.


## Converting Documentation to PDF format

We use [Google Chrome](https://www.google.com/chrome/browser/desktop/)
for converting documentation to PDF format, as Chrome’s PDF engine
preserves hyperlinks used in webpages.

Here are the steps to convert the project documentation files to PDF
format.

1.  Go to your generated documentation site on GitHub using Chrome.

2.  Within Chrome, click on the `Print` option in Chrome’s menu.

3.  Set the destination to `Save as PDF`, then click `Save` to save a
    copy of the file in PDF format. For best results, use the settings
    indicated in the screenshot below.

![Saving documentation as PDF files in
Chrome](images/chrome_save_as_pdf.png)

## Site-wide Documentation Settings
The `_config.yml` file specifies some project-specific attributes which
affect how all the documentation within this project are rendered.

|Attribute|Description|
|---|---|
|`title`|The title of your site, usually the name of your project.|
|`is-se-edu`|Set this to `false` if your project is not an official SE-EDU project.|

## Site Template

The files in `docs/_include` and `docs/_layouts` control the template
of the pages; the files in `docs/_sass` control the style of the pages.

{%include warning.html content="Modifying these files
requires some knowledge and experience with Jekyll.
You should only modify them if you need greater control over the site’s
layout. The SE-EDU team does notprovide support for modified template
files." %}
