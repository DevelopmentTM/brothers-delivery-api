package com.developmentteam.brothersdeliveryapi.dto.application;

import lombok.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

   private Integer status;
   private T response;

   public static <T> Builder<T> builder() {
      return new Builder<>();
   }

   public static class Builder<T> {

      private HttpStatus httpStatus;
      private HttpHeaders httpHeaders;
      private T response;

      public Builder<T> status(HttpStatus httpStatus) {
         this.httpStatus = httpStatus;
         return this;
      }

      public Builder<T> headers(HttpHeaders headers) {
         this.httpHeaders = headers;
         return this;
      }

      public Builder<T> response(T content) {
         this.response = content;
         return this;
      }

      public ResponseEntity<ApiResponse<T>> build() {
         ApiResponse<T> apiResponse = new ApiResponse<>(
                 this.httpStatus.value(), response
         );

         return ResponseEntity
                 .status(this.httpStatus)
                 .headers(this.httpHeaders)
                 .body(apiResponse);
      }
   }
}































