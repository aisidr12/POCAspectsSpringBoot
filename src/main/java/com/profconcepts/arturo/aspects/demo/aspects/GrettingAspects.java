package com.profconcepts.arturo.aspects.demo.aspects;

import java.time.LocalDateTime;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class GrettingAspects {

  private Logger logger = LoggerFactory.getLogger(this.getClass());


  @Before("greetingJoinPointCut()")
  public void beforeGrettingAspect(JoinPoint joinPoint) {
    logger.info("Entrando en beforeGrettingAspect");
    String methodName = joinPoint.getSignature().getName();
    String arguments = Arrays.toString(joinPoint.getArgs());
    logger.info("Metodo invocado: " + methodName + " con argumentos: " + arguments);
  }

  @After("execution(* com.profconcepts.arturo.aspects.demo..*.*(..))")
  public void afterGrettingAspect(JoinPoint joinPoint) {
    logger.info("Entrando en afterGrettingAspect");
    String methodName = joinPoint.getSignature().getName();
    String arguments = Arrays.toString(joinPoint.getArgs());
    logger.info("Metodo invocado Despues: " + methodName + " con argumentos: " + arguments);
  }

  @AfterReturning("execution(* com.profconcepts.arturo.aspects.demo.services.GrettingServiceImpl.sayHello(..))")
  public void afterReturningGrettingAspect(JoinPoint joinPoint) {
    logger.info("Entrando en afterReturningGrettingAspect");
    String methodName = joinPoint.getSignature().getName();
    String arguments = Arrays.toString(joinPoint.getArgs());
    logger.info("Metodo invocado AfterReturning : " + methodName + " con argumentos: " + arguments);
    logger.info(LocalDateTime.now().toString());
  }

  @AfterThrowing("execution(* com.profconcepts.arturo.aspects.demo..*.*(..))")
  public void afterThrowingGrettingAspect(JoinPoint joinPoint) {
    logger.info("Entrando en afterThrowingGrettingAspect");
    String methodName = joinPoint.getSignature().getName();
    String arguments = Arrays.toString(joinPoint.getArgs());
    logger.info("Metodo invocado AfterThrowing: " + methodName + " con argumentos: " + arguments);
  }
}
