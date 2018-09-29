package com.stackoverflow;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Arrays;

@Component
@Aspect
public class ProcedureAspect {

    static Logger logger = LoggerFactory.getLogger(ProcedureAspect.class);

    @Pointcut("execution(public @Log( secure = true ) *.new(..))")
    public void loggedSecureConstructor() {
    }

    @Pointcut("execution(@Log( secure = true ) * *.*(..))")
    public void loggedSecureMethod() {
    }

    @Pointcut("execution(public @Log( secure = false ) *.new(..))")
    public void loggedConstructor() {
    }

    @Pointcut("execution(@Log( secure = false ) * *.*(..))")
    public void loggedMethod() {
    }

    @Pointcut("execution(* (@Log *) .*(..)) && !@annotation(Log)")
    public void loggedClass() {
    }

    @Around("loggedSecureMethod() || loggedSecureConstructor()")
    public Object logSecure(final ProceedingJoinPoint joinPoint) throws Throwable {
        return log(joinPoint, true);
    }

    @Around("loggedMethod() || loggedConstructor() || loggedClass()")
    public Object log(final ProceedingJoinPoint joinPoint) throws Throwable {
        return log(joinPoint, false);
    }

    public Object log(ProceedingJoinPoint joinPoint, boolean secure) throws Throwable {
        final Signature signature = joinPoint.getSignature();

        String clazz = signature.getDeclaringTypeName();
        String method = signature.getName();
        final Object[] args = joinPoint.getArgs();
        final String params = secure ? "[SECURE]" : Arrays.deepToString(args);

        String message = MessageFormat.format("{0}#{1}({2})", clazz, method, params);
        logger.info(message);

        try {
            return args == null ? joinPoint.proceed() : joinPoint.proceed(args);
        } catch (Throwable e) {
            throw e;
        }
    }

}
