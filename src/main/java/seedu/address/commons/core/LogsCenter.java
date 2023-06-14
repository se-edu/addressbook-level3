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
    private static final String BASE_LOGGER_NAME = "ab3";
    private static final String LOG_FILE = "addressbook.log";
    private static Level currentLogLevel = Level.INFO;
    private static final Logger baseLogger = LogsCenter.getBaseLogger();
    private static final Logger logger = LogsCenter.getLogger(LogsCenter.class);

    /**
     * Initializes loggers with the log level specified in the {@code config} object. Applies to all loggers created
     * using {@link #getLogger(String)} and {@link #getLogger(Class)} methods except for those that are manually
     * tweaked.
     */
    public static void init(Config config) {
        currentLogLevel = config.getLogLevel();
        logger.info("currentLogLevel: " + currentLogLevel);
        // set the level of the baseLogger so that all other loggers will also be set to the same level
        baseLogger.setLevel(currentLogLevel);
    }

    /**
     * Creates a logger with the given name.
     */
    public static Logger getLogger(String name) {
        // Java organizes loggers into a hierarchy based on their names (using '.' as a separator, similar to how Java
        // packages form a hierarchy). Furthermore, loggers without a level inherit the level of their parent logger.
        // By prefixing names of all loggers with baseLogger's name + ".", we make the baseLogger the parent of all
        // loggers. This allows us to change the level of all loggers simply by changing the baseLogger level.
        Logger logger = Logger.getLogger(BASE_LOGGER_NAME + "." + name);
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

    private static Logger getBaseLogger() {
        Logger baseLogger = Logger.getLogger(BASE_LOGGER_NAME);
        baseLogger.setUseParentHandlers(false);
        removeHandlers(baseLogger);
        baseLogger.addHandler(createConsoleHandler(Level.ALL));

        try {
            baseLogger.addHandler(createFileHandler(Level.ALL));
        } catch (IOException e) {
            logger.warning("Error adding file handler for logger.");
        }

        return baseLogger;
    }

    /**
     * Remove all the handlers from {@code logger}.
     */
    private static void removeHandlers(Logger logger) {
        Arrays.stream(logger.getHandlers())
                .forEach(logger::removeHandler);
    }

    /**
     * Creates a {@code FileHandler} for the log file.
     *
     * @param level the logging level of the file handler
     * @throws IOException if there are problems opening the file.
     */
    private static FileHandler createFileHandler(Level level) throws IOException {
        FileHandler fileHandler = new FileHandler(LOG_FILE, MAX_FILE_SIZE_IN_BYTES, MAX_FILE_COUNT, true);
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setLevel(level);
        return fileHandler;
    }

    /**
     * Creates a {@code ConsoleHandler} for the log file.
     *
     * @param level the logging level of the console handler
     */
    private static ConsoleHandler createConsoleHandler(Level level) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(level);
        return consoleHandler;
    }
}
