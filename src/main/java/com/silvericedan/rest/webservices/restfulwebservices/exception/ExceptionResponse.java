package com.silvericedan.rest.webservices.restfulwebservices.exception;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExceptionResponse {
  private Date timestamp;
  private String message;
  private String detail;

}
