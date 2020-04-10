---
layout: page
title: User Guide
---

## Introduction

AddressBook Level 3 (AB3) is for those who **prefer to use a desktop app
for managing contacts**. More importantly, AB3 is **optimized for those
who prefer to work with a Command Line Interface** (CLI) while still
having the benefits of a Graphical User Interface (GUI). If you can type
fast, AB3 can get your contact management tasks done faster than
traditional GUI apps. Interested? Jump to the [Quick
Start](#_quick_start) to get started. Enjoy\!

## Quick Start

1.  Ensure you have Java `11` or above installed in your Computer.

2.  Download the latest `addressbook.jar`
    [here](https://github.com/se-edu/addressbook-level3/releases).

3.  Copy the file to the folder you want to use as the home folder for
    your Address Book.

4.  Double-click the file to start the app. The GUI should appear in a
    few seconds.
    
    ![Ui](images/Ui.png)

5.  Type the command in the command box and press Enter to execute it.  
    e.g. typing **`help`** and pressing Enter will open the help window.

6.  Some example commands you can try:
    
      - **`list`** : lists all contacts
    
      - **`add`**`n/John Doe p/98765432 e/johnd@example.com a/John
        street, block 123, #01-01` : adds a contact named `John Doe` to
        the Address Book.
    
      - **`delete`**`3` : deletes the 3rd contact shown in the current
        list
    
      - **`exit`** : exits the app

7.  Refer to [Features](#Features) for details of each command.

## Features

>**Command Format**
>   - Words in `UPPER_CASE` are the parameters to be supplied by the user
    e.g. in `add n/NAME`, `NAME` is a parameter which can be used as
    `add n/John Doe`.
>   - Items in square brackets are optional e.g `n/NAME [t/TAG]` can be
    used as `n/John Doe t/friend` or as `n/John Doe`.
>   - Items with `…`​ after them can be used multiple times including zero
    times e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times),
    `t/friend`, `t/friend t/family` etc.
>   - Parameters can be in any order e.g. if the command specifies `n/NAME
    p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable."

### Viewing help : `help`

Format: `help`

### Adding a person: `add`

Adds a person to the address book  
Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

{%include tip.html content="A person can have any number of tags (including 0)" %}

Examples:

  - `add n/John Doe p/98765432 e/johnd@example.com a/John street,
    block 123, #01-01`

  - `add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate
    Prison p/1234567 t/criminal`

### Listing all persons : `list`

Shows a list of all persons in the address book.  
Format: `list`

### Editing a person : `edit`

Edits an existing person in the address book.  
Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

  - Edits the person at the specified `INDEX`. The index refers to the
    index number shown in the displayed person list. The index **must be
    a positive integer** 1, 2, 3, …​

  - At least one of the optional fields must be provided.

  - Existing values will be updated to the input values.

  - When editing tags, the existing tags of the person will be removed
    i.e adding of tags is not cumulative.

  - You can remove all the person’s tags by typing `t/` without
    specifying any tags after it.

Examples:

  - `edit 1 p/91234567 e/johndoe@example.com`  
    Edits the phone number and email address of the 1st person to be
    `91234567` and `johndoe@example.com` respectively.

  - `edit 2 n/Betsy Crower t/`  
    Edits the name of the 2nd person to be `Betsy Crower` and clears all
    existing tags.

### Locating persons by name: `find`

Finds persons whose names contain any of the given keywords.  
Format: `find KEYWORD [MORE_KEYWORDS]`

  - The search is case insensitive. e.g `hans` will match `Hans`

  - The order of the keywords does not matter. e.g. `Hans Bo` will match
    `Bo Hans`

  - Only the name is searched.

  - Only full words will be matched e.g. `Han` will not match `Hans`

  - Persons matching at least one keyword will be returned (i.e. `OR`
    search). e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:

  - `find John`  
    Returns `john` and `John Doe`

  - `find Betsy Tim John`  
    Returns any person having names `Betsy`, `Tim`, or `John`

### Deleting a person : `delete`

Deletes the specified person from the address book.  
Format: `delete INDEX`

  - Deletes the person at the specified `INDEX`.

  - The index refers to the index number shown in the displayed person
    list.

  - The index **must be a positive integer** 1, 2, 3, …​

Examples:

  - `list`  
    `delete 2`  
    Deletes the 2nd person in the address book.

  - `find Betsy`  
    `delete 1`  
    Deletes the 1st person in the results of the `find` command.

### Clearing all entries : `clear`

Clears all entries from the address book.  
Format: `clear`

### Exiting the program : `exit`

Exits the program.  
Format: `exit`

### Saving the data

Address book data are saved in the hard disk automatically after any
command that changes the data.  
There is no need to save manually.

### Encrypting data files `[coming in v2.0]`

*{explain how the user can enable/disable data encryption}*

## FAQ

**Q**: How do I transfer my data to another Computer?  
**A**: Install the app in the other computer and overwrite the empty
data file it creates with the file that contains the data of your
previous Address Book folder.

## Command Summary

  - **Add** `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`  
    e.g. `add n/James Ho p/22224444 e/jamesho@example.com a/123,
    Clementi Rd, 1234665 t/friend t/colleague`

  - **Clear** : `clear`

  - **Delete** : `delete INDEX`  
    e.g. `delete 3`

  - **Edit** : `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL]
    [a/ADDRESS] [t/TAG]…​`  
    e.g. `edit 2 n/James Lee e/jameslee@example.com`

  - **Find** : `find KEYWORD [MORE_KEYWORDS]`  
    e.g. `find James Jake`

  - **List** : `list`

  - **Help** : `help`
