package ru.agk13145.sciencejournal.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class LoggingAspect {

    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    //@Before("@annotation(ru.agk13145.sciencejournal.config.annotation.LoggingController)")
    @Before("execution(public * ru.agk13145.sciencejournal.controller.*Controller.*(..))")
    public void beforeCallAtMethod(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        logger.info("before " + jp.toString() + ", args=[" + args + "]");
    }

    //@After("@annotation(ru.agk13145.sciencejournal.config.annotation.LoggingController)")
    @After("execution(public * ru.agk13145.sciencejournal.controller.*Controller.*(..))")
    public void afterCallAt(JoinPoint jp) {
        logger.info("after " + jp.toString());
    }


}


