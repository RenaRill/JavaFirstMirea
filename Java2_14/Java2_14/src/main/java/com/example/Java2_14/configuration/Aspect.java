package com.example.Java2_14.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Around("allServices()")
    public Object logParameters(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            log.info("Method {} took {} ms to execute.", joinPoint.getSignature(),
                    System.currentTimeMillis() - startTime);
        }
    }
    @Pointcut("execution(* com.example.Java2_14.services.*.*(..)))")
    public void allServices() {}
}

