package students;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

public class MyLayout extends PatternLayout{
    @Override
    public String format(LoggingEvent event) {
        String str = event.getMessage().toString().toUpperCase();
        return str;
    }
}
