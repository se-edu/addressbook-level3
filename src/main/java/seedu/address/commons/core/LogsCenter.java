package seedu.address.commons.core;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Configures and manages loggers and handlers, including their logging level
 * Named {@link Logger}s can be obtained from this class<br>
 * These loggers have been configured to output messages to the console and a {@code .log} file by default,
 *   at the {@code INFO} level. A new {@code .log} file with a new numbering will be created after the log
 *   file reaches 5MB big, up to a maximum of 5 files.<br>
 */
public class LogsCenter {
    private static final int MAX_FILE_COUNT = 5;
    private static final int MAX_FILE_SIZE_IN_BYTES = (int) (Math.pow(2, 20) * 5); // 5MB
    private static final String LOG_FILE = "addressbook.log";
    private static final Logger logger; // logger for this class
    private static Logger baseLogger; // to be used as the parent of all other loggers created by this class.
    private static Level currentLogLevel = Level.INFO;

    // This static block ensures essential loggers are created early
    static {
        setBaseLogger();
        logger = LogsCenter.getLogger(LogsCenter.class);
    }

    /**
     * Initializes loggers with the log level specified in the {@code config} object. Applies to all loggers created
     * using {@link #getLogger(String)} and {@link #getLogger(Class)} methods except for those that are manually set.
     */
    public static void init(Config config) {
        currentLogLevel = config.getLogLevel();
        logger.info("Log level will be set as: " + currentLogLevel);
        // set the level of the baseLogger which will be inherited by other loggers
        baseLogger.setLevel(currentLogLevel);
    }

    /**
     * Creates a logger with the given name prefixed by the {@code baseLogger}'s name so that the created logger
     * becomes a descendant of the {@code baseLogger}. Furthermore, the returned logger will have the same log handlers
     * as the {@code baseLogger}.
     */
    public static Logger getLogger(String name) {
        // Java organizes loggers into a hierarchy based on their names (using '.' as a separator, similar to how Java
        // packages form a hierarchy). Furthermore, loggers without a level inherit the level of their parent logger.
        // By prefixing names of all loggers with baseLogger's name + ".", we make the baseLogger the parent of all
        // loggers. This allows us to change the level of all loggers simply by changing the baseLogger level.
        Logger logger = Logger.getLogger(baseLogger.getName() + "." + name);
        removeHandlers(logger);
        logger.setUseParentHandlers(true);
        return logger;
    }

    /**
     * Creates a Logger for the given class name.
     */
    public static <T> Logger getLogger(Class<T> clazz) {
        requireNonNull(clazz);
        return getLogger(clazz.getSimpleName());
    }

    /**
     * Removes all handlers from the {@code logger}.
     */
    private static void removeHandlers(Logger logger) {
        Arrays.stream(logger.getHandlers())
                .forEach(logger::removeHandler);
    }

    /**
     * Creates a logger named 'ab3', containing a {@code ConsoleHandler} and a {@code FileHandler}.
     * Sets it as the {@code baseLogger}, to be used as the parent logger of all other loggers.
     */
    private static void setBaseLogger() {
        baseLogger = Logger.getLogger("ab3");
        baseLogger.setUseParentHandlers(false);
        removeHandlers(baseLogger);

        // Level.ALL is used as the level for the handlers because the baseLogger filters the log messages by level
        // already; there is no need to control log message level of the handlers.

        // add a ConsoleHandler to log to the console
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        baseLogger.addHandler(consoleHandler);

        // add a FileHandler to log to a file
        try {
            FileHandler fileHandler = new FileHandler(LOG_FILE, MAX_FILE_SIZE_IN_BYTES, MAX_FILE_COUNT, true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL);
            baseLogger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.warning("Error adding file handler for logger.");
        }
    }


}
