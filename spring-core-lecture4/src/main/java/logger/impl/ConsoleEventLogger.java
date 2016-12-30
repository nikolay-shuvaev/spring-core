package logger.impl;

import dto.Event;
import logger.EventLogger;
import org.springframework.stereotype.Service;

/**
 * Created by NICK on 28.12.2016.
 */
@Service
public class ConsoleEventLogger implements EventLogger {

    @Override
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
