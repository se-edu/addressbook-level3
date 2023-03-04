package seedu.address.commons.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import java.util.logging.Level;

import org.junit.jupiter.api.Test;

public class ConfigTest {

    @Test
    public void toString_defaultObject_stringReturned() {
        String defaultConfigAsString = "Current log level : INFO\n"
                + "Preference file Location : preferences.json";

        assertEquals(defaultConfigAsString, new Config().toString());
    }

    @Test
    public void logLevel_defaultObject_success() {
        Level logLevel = new Config().getLogLevel();
    }

    @Test
    public void userPref_defaultObject_success() {
        Path filePath = new Config().getUserPrefsFilePath();
    }

    @Test
    public void equalsMethod() {
        Config defaultConfig = new Config();
        Object notConfig = new Object();
        assertNotNull(defaultConfig);
        assertTrue(defaultConfig.equals(defaultConfig));
        assertFalse(defaultConfig.equals(notConfig));
    }

    @Test
    public void hashCodeMethod() {
        Config defaultConfig = new Config();
        assertNotNull(defaultConfig.hashCode());
    }
}
