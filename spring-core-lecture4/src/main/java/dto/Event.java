package dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by NICK on 29.12.2016.
 */
@Component
@Scope("prototype")
public class Event {
    private int id = new Random().nextInt();
    private String message;
    private final Date date;
    private DateFormat dateFormat;

    @Autowired
    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
