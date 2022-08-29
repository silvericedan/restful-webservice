package com.silvericedan.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonFilter("DinaBeanFilter")
public class DinaBean {

  private String field1;

  private String field2;

  private String field3;
}
