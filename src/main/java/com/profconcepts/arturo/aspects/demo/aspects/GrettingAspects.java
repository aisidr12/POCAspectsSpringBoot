package com.profconcepts.arturo.aspects.demo.aspects;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GrettingAspects {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Before("execution(* com.profconcepts.arturo.aspects.demo.services.GrettingServiceImpl.sayHello(..))")
  public void beforeGrettingAspect(JoinPoint joinPoint) {
    logger.info("Entrando en beforeGrettingAspect");
    String methodName = joinPoint.getSignature().getName();
    String arguments = Arrays.toString(joinPoint.getArgs());
    logger.info("Metodo invocado: " + methodName + " con argumentos: " + arguments);
  }

}
