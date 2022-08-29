package com.silvericedan.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonProperty;
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
  @JsonProperty("user_name") //JsonProperty allows to customize the attribute names and elements in the response
  private String name;

  @Past(message = "Birth Date must be a past date")
  private Date birthDate;

}
