package logger.impl;

import dto.Event;
import logger.EventLogger;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by NICK on 29.12.2016.
 */
@Service
public class FileEventLogger implements EventLogger {
    private File file;

    private String fileName;

    @PostConstruct
    private void init() throws IllegalAccessException {
        this.file = new File(fileName);
        boolean canWrite = file.canWrite();
        if (!canWrite) {
            throw new IllegalAccessException("Could not write");
        }
    }

    @Value("log.txt")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(new File(fileName), event.toString() + "\r\n", Charset.defaultCharset(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
