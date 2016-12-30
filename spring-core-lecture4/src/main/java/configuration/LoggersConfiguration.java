package configuration;

import logger.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nikolai_Shuvaev on 12/30/2016.
 */
@Configuration
@ComponentScan("logger")
public class LoggersConfiguration {
    @Autowired
    private EventLogger consoleEventLogger;
    @Autowired
    private EventLogger fileEventLogger;

    public List<EventLogger> eventLoggers() {
        return Arrays.asList(consoleEventLogger, fileEventLogger);
    }
}
