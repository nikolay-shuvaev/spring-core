package defaultt;

import client.Client;
import configuration.AppConfiguration;
import configuration.LoggersConfiguration;
import dto.Event;
import dto.EventType;
import logger.EventLogger;
import logger.impl.CacheFileEventLogger;
import logger.impl.ConsoleEventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;

/**
 * Created by NICK on 28.12.2016.
 */
@Component
public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;

    private Map<EventType, EventLogger> loggers;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class, LoggersConfiguration.class);

        App app = (App) context.getBean("app");

        Event event = (Event) context.getBean("event");
        event.setMessage("Client information - " + app.client);
        app.logEvent(EventType.INFO, event);

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

    @Autowired
    public void setClient(Client client) {
        this.client = client;
    }

    @Autowired
    @Qualifier("consoleEventLogger")
    public void setEventLogger(ConsoleEventLogger eventLogger) {
        this.eventLogger = eventLogger;
    }

    @Resource(name = "loggersByType")
    public void setLoggers(Map<EventType, EventLogger> loggers) {
        this.loggers = loggers;
    }

}
