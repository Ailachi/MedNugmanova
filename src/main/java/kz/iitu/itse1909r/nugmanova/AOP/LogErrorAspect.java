package kz.iitu.itse1909r.nugmanova.AOP;

import kz.iitu.itse1909r.nugmanova.Database.ErrorLog;
import kz.iitu.itse1909r.nugmanova.Repository.ErrorLogRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LogErrorAspect {

    private ErrorLogRepository logRepo = null;
    private Environment environment = null;

    @Autowired
    public LogErrorAspect(Environment environmentt, ErrorLogRepository errorLogRepository) {
        environment = environmentt;
        logRepo = errorLogRepository;
    }

    @Pointcut("@annotation(kz.iitu.itse1909r.nugmanova.AOP.LogErrorEntry)")
    public void authorizationAnnotatedMethods() {}

    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void allServiceClasses() {}

    @Around("authorizationAnnotatedMethods() || allServiceClasses()")
    public Object authorize(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getClass().getName();

        Object commence = null;
        try {
            commence = joinPoint.proceed();
        } catch (Throwable e) {
            ErrorLog error = new ErrorLog();
            error.setOrigin(className + ": " + methodName);
            error.setStackTrace(e.getStackTrace().toString());
            error.setTime(LocalDateTime.now());
            logRepo.save(error);
        }
        return commence;
    }
}
