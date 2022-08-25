package com.silvericedan.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

  //Different options to do Versioning
  //URI Versioning
  @GetMapping("/v1/person")
  public PersonV1 getFirstVersionOfPerson(){
    return new PersonV1("Bob Charlie");
  }

  @GetMapping("/v2/person")
  public PersonV2 getSecondVersionOfPerson(){
    return new PersonV2(new Name("Bob","Charlie"));
  }

  //Request Parameter versioning - Amazon
  @GetMapping(path ="/person", params = "version=1")
  public PersonV1 getFirstVersionOfPersonRequestParameter(){
    return new PersonV1("Buba Fisherman");
  }


  @GetMapping(path ="/person", params = "version=2")
  public PersonV2 getSecondVersionOfPersonRequestParameter(){
    return new PersonV2(new Name("Buba","Fisherman"));
  }

  //(Custom) headers versioning - Microsoft
  @GetMapping(path ="/person/header", headers = "X-API-VERSION=1")
  public PersonV1 getFirstVersionOfPersonRequestHeader(){
    return new PersonV1("Helmeppo Headerman");
  }

  @GetMapping(path ="/person/header", headers = "X-API-VERSION=2")
  public PersonV2 getSecondVersionOfPersonRequestHeader(){
    return new PersonV2(new Name("Helmeppo","Headerman"));
  }

  //Media type versioning (aka "content negotiation" or "accept header") - Github
  @GetMapping(path ="/person/accept", produces = "application/vnd.company.app-v1+json")
  public PersonV1 getFirstVersionOfPersonAcceptHeader(){
    return new PersonV1("Helmeppo Headerman");
  }

  @GetMapping(path ="/person/accept", produces = "application/vnd.company.app-v2+json")
  public PersonV2 getSecondVersionOfPersonAcceptHeader(){
    return new PersonV2(new Name("Helmeppo","Headerman"));
  }
}
