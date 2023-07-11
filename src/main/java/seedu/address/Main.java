package seedu.address;

import java.util.logging.Logger;

import javafx.application.Application;
import seedu.address.commons.core.LogsCenter;

/**
 * The main entry point to the application.
 *
 * This is a workaround for the following error when MainApp is made the
 * entry point of the application:
 *
 *     Error: JavaFX runtime components are missing, and are required to run this application
 *
 * The reason is that MainApp extends Application. In that case, the
 * LauncherHelper will check for the javafx.graphics module to be present
 * as a named module. We don't use JavaFX via the module system so it can't
 * find the javafx.graphics module, and so the launch is aborted.
 *
 * By having a separate main class (Main) that doesn't extend Application
 * to be the entry point of the application, we avoid this issue.
 */
public class Main {
    private static Logger logger = LogsCenter.getLogger(Main.class);

    public static void main(String[] args) {

        // As per https://github.com/openjdk/jfx/blob/master/doc-files/release-notes-16.md
        // JavaFX 16 (or later) runtime logs a warning at startup if JavaFX classes are loaded from
        // the classpath instead of a module.
        // Our application does not use Java modules yet. Even if it did, modules are ignored when
        // packed into a FAT Jar file (as we do), which means this warning will persist even then.
        // The warning however, can be safely ignored. Thus, the following log informs
        // the user (if looking at the log output) that the said warning appearing in the log
        // can be ignored.

        logger.warning("The warning about Unsupported JavaFX configuration below can be ignored.");
        Application.launch(MainApp.class, args);
    }
}
