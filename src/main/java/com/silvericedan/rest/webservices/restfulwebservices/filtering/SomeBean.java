package com.silvericedan.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SomeBean {

  private String field1;

  @JsonIgnore
  private String field2;

  private String field3;
}
