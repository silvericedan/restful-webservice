package com.silvericedan.rest.webservices.restfulwebservices.versioning;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Name {

  private String firstName;
  private String lastName;
}
