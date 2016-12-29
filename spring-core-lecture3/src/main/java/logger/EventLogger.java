package logger;

import dto.Event;

/**
 * Created by NICK on 28.12.2016.
 */
public interface EventLogger {
    void logEvent(Event event);
}
