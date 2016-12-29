package logger.impl;

import dto.Event;
import logger.EventLogger;

/**
 * Created by NICK on 28.12.2016.
 */
public class ConsoleEventLogger implements EventLogger {

    @Override
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
