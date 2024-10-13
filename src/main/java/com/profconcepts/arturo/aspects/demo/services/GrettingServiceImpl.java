package com.profconcepts.arturo.aspects.demo.services;

import org.springframework.stereotype.Service;

@Service
public class GrettingServiceImpl implements GrettingService {

  @Override
  public String sayHello(String person, String phrase) {
    String salut = phrase + " " + person + "!";
    System.out.println(salut);
    return salut;
  }

  @Override
  public String sayHelloError(String person, String phrase) {
     throw new RuntimeException("Error test AOP Throwing");
  }
}
