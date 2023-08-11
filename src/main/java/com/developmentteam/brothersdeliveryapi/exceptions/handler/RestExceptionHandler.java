package com.developmentteam.brothersdeliveryapi.exceptions.handler;

import com.developmentteam.brothersdeliveryapi.exceptions.body.ApiErrorBody;
import com.developmentteam.brothersdeliveryapi.exceptions.body.ValidateExceptionBody;
import com.developmentteam.brothersdeliveryapi.exceptions.custom.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Locale;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler {

   private final MessageSource messageSource;

   @ExceptionHandler({  MethodArgumentNotValidException.class })
   public ResponseEntity<ApiErrorBody> handleArgumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest request, Locale locale) {

      List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
      var fieldList = processFieldError(fieldErrors);

      var httpStatus = HttpStatus.BAD_REQUEST;

      ApiErrorBody apiErrorBody = ValidateExceptionBody.builder()
              .status(httpStatus.value())
              .error(ex.getClass().getName())
              .message(ex.getMessage())
              .path(request.getRequestURI())
              .timestamp(OffsetDateTime.now())
              .fields(fieldList)
              .build();

      return ResponseEntity.status(httpStatus).body(apiErrorBody);
   }

   private List<ValidateExceptionBody.Field> processFieldError(List<FieldError> fieldErrors) {
      return  fieldErrors.stream()
              .map(fieldError ->  ValidateExceptionBody.Field.builder()
                      .fieldName(fieldError.getField())
                      .fieldErrorMessage(fieldError.getDefaultMessage())
              .build()
      ).toList();
   }

   private ApiErrorBody toApiErrorBody(HttpStatus httpStatus,  Throwable ex, HttpServletRequest request) {
      return  ApiErrorBody.builder()
              .status(httpStatus.value())
              .error(ex.getClass().getSimpleName())
              .message(ex.getMessage())
              .path(request.getRequestURI())
              .timestamp(OffsetDateTime.now())
              .build();
   }

   private HttpStatus getStatusOfExceptionClass(Throwable throwable) {
      return throwable.getClass().getDeclaredAnnotation(ResponseStatus.class).value();
   }

   @ExceptionHandler({ ResourceNotFoundException.class })
   public ResponseEntity<ApiErrorBody> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
      HttpStatus httpStatus = this.getStatusOfExceptionClass(ex);
      var apiErrorBody = this.toApiErrorBody(httpStatus, ex, request);
      return ResponseEntity.status(httpStatus).body(apiErrorBody);
   }

}























