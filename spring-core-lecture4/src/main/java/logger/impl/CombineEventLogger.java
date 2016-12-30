package logger.impl;

import dto.Event;
import logger.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by NICK on 29.12.2016.
 */
@Service
public class CombineEventLogger implements EventLogger {
    private List<EventLogger> eventLoggers;

    @Autowired
    public CombineEventLogger(List<EventLogger> eventLoggers) {
        this.eventLoggers = eventLoggers;
    }


    @Override
    public void logEvent(Event event) {
        eventLoggers.forEach(eventLogger -> eventLogger.logEvent(event));
    }
}
