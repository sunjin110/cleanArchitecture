package info.sunjin.cleanArchitecture.presenteter.restapi.middleware;

import info.sunjin.cleanArchitecture.utils.LoggingUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger("AccessLog");

    @Before("@annotation(AccessLog)")
    public void beforeAdvice(JoinPoint joinPoint) {
        LoggingUtil.startLoggingContext();
        logger.info("request_start:" + joinPoint.getSignature().getName());
    }

    @After("@annotation(AccessLog)")
    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("request_end:" + joinPoint.getSignature().getName());
        LoggingUtil.clearLoggingContext();
    }
}
