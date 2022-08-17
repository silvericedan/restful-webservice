package com.silvericedan.rest.webservices.restfulwebservices.user;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class User {

  private Integer id;

  private String name;

  private Date birthDate;

}
