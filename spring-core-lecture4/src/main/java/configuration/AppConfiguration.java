package configuration;

import defaultt.App;
import dto.EventType;
import logger.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikolai_Shuvaev on 12/30/2016.
 */
@Configuration
@ComponentScan({"defaultt", "client", "dto"})
@Import(LoggersConfiguration.class)
@PropertySource("classpath:client.properties")
public class AppConfiguration {
    @Autowired
    private EventLogger consoleEventLogger;
    @Autowired
    private EventLogger combineEventLogger;

    @Bean
    public App app() {
        return new App();
    }

    @Bean
    public Date date() {
        return new Date();
    }

    @Bean
    public DateFormat dateFormat() {
        return DateFormat.getDateInstance();
    }

    @Bean
    public Map<EventType, EventLogger> loggersByType() {
        Map<EventType, EventLogger> map = new HashMap<>();
        map.put(EventType.ERROR, combineEventLogger);
        map.put(EventType.INFO, consoleEventLogger);
        return map;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
