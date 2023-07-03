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
        /**
         * Since JavaFX 16, JavaFX runtime logs a warning if javafx.* modules are loaded from the classpath.
         * This will result in a warning message whenever the application is launched.
         * As modules are ignored when packed into a FAT Jar file, this warning will always be shown regardless
         * of whether the application is using modules or not.
         *
         * This warning however, can be safely ignored. Thus, this log is used to inform the user that the warning
         * can be ignored.
         * https://github.com/openjdk/jfx/blob/master/doc-files/release-notes-16.md
         */
        logger.info("The warning about Unsupported JavaFX configuration below can be ignored.");
        Application.launch(MainApp.class, args);
    }
}
