package com.profconcepts.arturo.aspects.demo.aspects;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class GrettingFooAspects {

  private Logger logger = LoggerFactory.getLogger(this.getClass());


  @Before("grettingFooJoinPointCut()")
  private void loggerBefore(JoinPoint joinPoint){
    logger.info("Entrando en beforeGrettingAspect order 1");
    String methodName = joinPoint.getSignature().getName();
    String arguments = Arrays.toString(joinPoint.getArgs());
    logger.info("Metodo invocado: " + methodName + " con argumentos: " + arguments);
  }
}
