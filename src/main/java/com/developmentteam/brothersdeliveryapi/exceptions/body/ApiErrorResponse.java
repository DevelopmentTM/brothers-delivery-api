package com.developmentteam.brothersdeliveryapi.exceptions.body;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public sealed class ApiErrorResponse implements Serializable permits ValidateExceptionResponse {

   protected  Integer status;
   protected  String error;
   protected  String message;
   protected  String path;
   protected OffsetDateTime timestamp;

}
