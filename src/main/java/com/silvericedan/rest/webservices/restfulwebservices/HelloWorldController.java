package com.silvericedan.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

  //GET
  //URI - /helloworld
  //method - "Hello World"
  @GetMapping(path = "/hello-world")
  public String helloWorld(){
    return "Hello World";
  }

  //hello-world-bean
  @GetMapping(path = "/hello-world-bean")
  public HelloWorldBean helloWorldBean(){
    return new HelloWorldBean("Hello World");
  }
}
