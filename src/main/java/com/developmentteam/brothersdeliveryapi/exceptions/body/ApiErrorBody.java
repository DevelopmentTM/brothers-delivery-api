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
public sealed  class ApiErrorBody implements Serializable permits ValidateExceptionBody {

   protected  Integer status;
   protected  String error;
   protected  String message;
   protected  String path;
   protected OffsetDateTime timestamp;

}
