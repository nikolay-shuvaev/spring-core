package logger.impl;

import dto.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NICK on 29.12.2016.
 */
public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<>(cacheSize);
    }

    private void destroy() {
        if (!cache.isEmpty()) {
            writesEventsFromCache();
        }
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writesEventsFromCache();
            cache.clear();
        }
    }

    private void writesEventsFromCache() {
        cache.forEach(super::logEvent);
    }
}
