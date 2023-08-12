package com.developmentteam.brothersdeliveryapi.controllers.auth;

import com.developmentteam.brothersdeliveryapi.dto.application.ApiMessage;
import com.developmentteam.brothersdeliveryapi.dto.application.ApiResponse;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

//   @GetMapping( "/{nb}")
//   public ResponseEntity<?> test(@PathVariable Integer nb) {
//      if (nb == 1) {
//
//         return ApiResponse.<ApiMessage>builder()
//                 .status(HttpStatus.OK)
//                 .response(ApiMessage.of("test message"))
//                 .build();
//
//      }
//
//      var pd = new Pd("nome product", "desc product");
//      return ApiResponse.<Pd>builder()
//              .status(HttpStatus.OK)
//              .response(pd)
//              .build();
//
//   }
//
//   @Getter
//   @Setter
//   @AllArgsConstructor
//   static class Pd {
//      String name;
//      String description;
//   }

}
