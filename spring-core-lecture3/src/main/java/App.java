import client.Client;
import dto.Event;
import dto.EventType;
import logger.EventLogger;
import logger.impl.CacheFileEventLogger;
import logger.impl.ConsoleEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Random;

/**
 * Created by NICK on 28.12.2016.
 */
public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, ConsoleEventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        App app = (App) context.getBean("app");

        app.logEvent(EventType.INFO, getEvent(context));
        app.logEvent(EventType.INFO, getEvent(context));
        app.logEvent(EventType.INFO, getEvent(context));
        app.logEvent(EventType.INFO, getEvent(context));
        app.logEvent(EventType.INFO, getEvent(context));
        app.logEvent(EventType.INFO, getEvent(context));
        app.logEvent(EventType.INFO, getEvent(context));
        app.logEvent(EventType.INFO, getEvent(context));
        app.logEvent(EventType.INFO, getEvent(context));
        app.logEvent(EventType.INFO, getEvent(context));
        app.logEvent(EventType.INFO, getEvent(context));
        app.logEvent(EventType.ERROR, getEvent(context));
        app.logEvent(EventType.ERROR, getEvent(context));
        app.logEvent(EventType.ERROR, getEvent(context));
        app.logEvent(EventType.ERROR, getEvent(context));
        app.logEvent(EventType.ERROR, getEvent(context));
        app.logEvent(EventType.ERROR, getEvent(context));
        app.logEvent(EventType.ERROR, getEvent(context));
        app.logEvent(null, getEvent(context));
        app.logEvent(null, getEvent(context));
        app.logEvent(null, getEvent(context));
        app.logEvent(null, getEvent(context));
        app.logEvent(null, getEvent(context));
        app.logEvent(null, getEvent(context));
        app.logEvent(null, getEvent(context));
        app.logEvent(null, getEvent(context));
        app.logEvent(null, getEvent(context));
        app.logEvent(null, getEvent(context));
        app.logEvent(null, getEvent(context));
        app.logEvent(null, getEvent(context));
        app.logEvent(null, getEvent(context));
        app.logEvent(null, getEvent(context));
        app.logEvent(null, getEvent(context));
    }

    private static Event getEvent(ApplicationContext context) {
        Event event = (Event) context.getBean("event");
        event.setMessage("Some message for User " + new Random().nextInt());
        return event;
    }

    private void logEvent(EventType type, Event event) {
        EventLogger eventLogger = loggers.get(type);
        if (eventLogger == null) {
            eventLogger = this.eventLogger;
        }
        System.out.println("EVENT TYPE: " + type);
        eventLogger.logEvent(event);
    }

}
