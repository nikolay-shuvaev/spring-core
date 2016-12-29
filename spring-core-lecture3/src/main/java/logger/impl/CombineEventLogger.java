package logger.impl;

import dto.Event;
import logger.EventLogger;

import java.util.List;

/**
 * Created by NICK on 29.12.2016.
 */
public class CombineEventLogger implements EventLogger {
    private List<EventLogger> eventLoggers;

    public CombineEventLogger(List<EventLogger> eventLoggers) {
        this.eventLoggers = eventLoggers;
    }


    @Override
    public void logEvent(Event event) {
        eventLoggers.forEach(eventLogger -> eventLogger.logEvent(event));
    }
}
