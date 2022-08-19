package com.silvericedan.rest.webservices.restfulwebservices.user;

import java.util.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
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
  @Size(min=2, message = "Name should have at least 2 characters")
  private String name;
  @Past(message = "Birth Date must be a past date")
  private Date birthDate;

}
