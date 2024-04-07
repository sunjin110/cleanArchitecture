package info.sunjin.cleanArchitecture.utils;

import org.apache.logging.log4j.ThreadContext;

import java.util.UUID;

public class LoggingUtil {
        public static void startLoggingContext() {
            ThreadContext.put("thread", UUID.randomUUID().toString());
        }

        public static void clearLoggingContext() {
            ThreadContext.clearMap();
        }
}
