---
layout: page
title: Logging Guide
---

We are using `java.util.logging` package for logging. The `LogsCenter`
class is used to manage the logging levels and logging destinations.

*  The logging level can be controlled using the `logLevel` setting in the configuration file (See the [Configuration](#configuration) section).
*  The `Logger` for a class can be obtained using `LogsCenter.getLogger(Class)` which will log messages according to the specified logging level.
*  Log messages are output through: `Console` and to a `.log` file.

**Logging Levels**

* `SEVERE`: A critical problem detected which may cause the termination of the application.
* `WARNING`: Can continue, but with caution.
* `INFO`: Information showing the noteworthy actions by the App.
* `FINE`: Details that is not usually noteworthy but may be useful in debugging e.g. print the actual list instead of just its size.

