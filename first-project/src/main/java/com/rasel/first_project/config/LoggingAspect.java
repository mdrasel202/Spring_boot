package com.rasel.first_project.config;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	// private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(* com.rasel.first_project.service.*.*(..))")
	public void servicePointcut() {

	}

	@Pointcut("execution(* com.rasel.first_project.controller.*.*(..))")
	public void controllerPointcut() {

	}

	@Before("servicePointcut()")
	public void logBeforeService(JoinPoint joinPoint) {
		log.info("Starting service method: {} with arguments: {}", joinPoint.getSignature().getName(),
				Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "servicePointcut()", returning = "result")
	public void logAfterService(JoinPoint joinPoint, Object result) {
		log.info("Service method: {} completed with result: {}", joinPoint.getSignature().getName(), result);
	}

	@AfterThrowing(pointcut = "servicePointcut()", throwing = "exception")
	public void logServiceException(JoinPoint joinPoint, Exception exception) {
		log.info("Exception in service method: {} with exception: {}", joinPoint.getSignature().getName(),
				exception.getMessage());
	}

	@Around("controllerPointcut()")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		log.info("Starting controller method: {}", joinPoint.getSignature().getName());

		try {
			Object result = joinPoint.proceed();

			long endTime = System.currentTimeMillis();
			log.info("Controller method: {} completed in {}ms", joinPoint.getSignature().getName(),
					(endTime - startTime));

			return result;
		} catch (Exception e) {
			log.error("Exception in controller method: {} with message: {}", joinPoint.getSignature().getName(),
					e.getMessage());

			throw e;
		}
	}
}
