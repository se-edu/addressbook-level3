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
    private static final String BASE_LOGGER_NAME = "seedu.address";
    private static final String LOG_FILE = "addressbook.log";
    private static Level currentLogLevel = Level.INFO;
    private static final Logger logger = LogsCenter.getLogger(LogsCenter.class);
    private static FileHandler fileHandler;
    private static ConsoleHandler consoleHandler;
    private static final Logger baseLogger = Logger.getLogger(BASE_LOGGER_NAME);

    /**
     * Initializes with a custom log level (specified in the {@code config} object). All Loggers
     * created using {@link #getLogger(String)} and {@link #getLogger(Class)} will have the same log
     * level as the one specified in the {@code config} object.
     */
    public static void init(Config config) {
        currentLogLevel = config.getLogLevel();
        logger.info("currentLogLevel: " + currentLogLevel);
        baseLogger.setLevel(currentLogLevel);

        // Set the log level of log handlers to the current log level if they are not null
        if (fileHandler != null) {
            fileHandler.setLevel(currentLogLevel);
        }
        if (consoleHandler != null) {
            consoleHandler.setLevel(currentLogLevel);
        }
    }

    /**
     * Creates a logger with the given name.
     */
    public static Logger getLogger(String name) {
        Logger logger = Logger.getLogger(name);
        logger.setUseParentHandlers(false);

        removeHandlers(logger);
        addConsoleHandler(logger);
        addFileHandler(logger);

        return Logger.getLogger(name);
    }

    /**
     * Creates a Logger for the given class name.
     */
    public static <T> Logger getLogger(Class<T> clazz) {
        requireNonNull(clazz);
        // The BASE_LOGGER_NAME acts as a common prefix for all application loggers,
        // organizing them based on functionality or module.
        // The dot (".") serves as a separator, reflecting the package structure and providing a
        // hierarchical representation.

        // Changing the BASE_LOGGER_NAME affects all related loggers, enabling centralized control
        // over their configuration and behavior. It allows for easy adjustment of multiple loggers
        // simultaneously.
        return getLogger(BASE_LOGGER_NAME + "." + clazz.getSimpleName());
    }

    /**
     * Adds the {@code consoleHandler} to the {@code logger}. <br>
     * Creates the {@code consoleHandler} if it is null.
     */
    private static void addConsoleHandler(Logger logger) {
        if (consoleHandler == null) {
            consoleHandler = createConsoleHandler();
        }
        logger.addHandler(consoleHandler);
    }

    /**
     * Remove all the handlers from {@code logger}.
     */
    private static void removeHandlers(Logger logger) {
        Arrays.stream(logger.getHandlers())
                .forEach(logger::removeHandler);
    }

    /**
     * Adds the {@code fileHandler} to the {@code logger}. <br>
     * Creates {@code fileHandler} if it is null.
     */
    private static void addFileHandler(Logger logger) {
        try {
            if (fileHandler == null) {
                fileHandler = createFileHandler();
            }
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.warning("Error adding file handler for logger.");
        }
    }

    /**
     * Creates a {@code FileHandler} for the log file.
     * @throws IOException if there are problems opening the file.
     */
    private static FileHandler createFileHandler() throws IOException {
        FileHandler fileHandler = new FileHandler(LOG_FILE, MAX_FILE_SIZE_IN_BYTES, MAX_FILE_COUNT, true);
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setLevel(currentLogLevel);
        return fileHandler;
    }

    private static ConsoleHandler createConsoleHandler() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(currentLogLevel);
        return consoleHandler;
    }
}
