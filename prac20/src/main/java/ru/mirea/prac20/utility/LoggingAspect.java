package ru.mirea.prac20.utility;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

//@EnableAspectJAutoProxy
@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Around("allServiceMethods()")
    public Object logParameters(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info(proceedingJoinPoint.getSignature().getName() + "выполнено за " + (endTime - startTime) + " мс");
        return result;
    }

    @Pointcut("execution(* ru.mirea.prac20.service.WorkerService.*(..))")
    public void allServiceMethods() {}

    /*@Pointcut("execution(* com.kerrli.BanksystemJava_4sem.service.EmployeeService.*(..))")
    public void employeeServicePointcut() {}

    @Pointcut("employeeServicePointcut()")
    public void serviceLogging() {}

    @Before("serviceLogging()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("LOGGING!!!");
        return null;
    }*/
}
