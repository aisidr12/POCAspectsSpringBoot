package com.profconcepts.arturo.aspects.demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GrettingServicePointCut {

  /***
   * Pointcut for all methods in the package
   * Also is one way to uncouple the pointcut from other classes
   * Is important to have the same name from the method
   */
  @Pointcut("execution(* com.profconcepts.arturo.aspects.demo.services.GrettingServiceImpl.sayHello(..))")
  private void greetingJoinPointCut() {
  }

  @Pointcut("execution(* com.profconcepts.arturo.aspects.demo.services.GrettingServiceImpl.sayHello(..))")
  private void grettingFooJoinPointCut() {
  }


}
