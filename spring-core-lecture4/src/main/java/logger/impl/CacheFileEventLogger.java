package logger.impl;

import dto.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NICK on 29.12.2016.
 */
@Service
public class CacheFileEventLogger extends FileEventLogger {
    @Value("5")
    private int cacheSize;
    private List<Event> cache;

    @PostConstruct
    private void init() {
        this.cache = new ArrayList<>(cacheSize);
    }

    @PreDestroy
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
