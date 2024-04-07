package info.sunjin.cleanArchitecture.log;

import org.apache.logging.log4j.LogManager;

public class Logger {

    private final org.apache.logging.log4j.Logger logger;

    public Logger(final Class<?> clazz) {
        this.logger = LogManager.getLogger(clazz);
    }

    public void info() {
        this.logger.info("");
    }
}
