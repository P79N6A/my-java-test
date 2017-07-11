package log.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 17/4/14.
 */
public class LogBackTest {
    public static Logger logger = LoggerFactory.getLogger(LogBackTest.class);

    public static void main(String[] args) {
        logger.info("test");
    }
}
