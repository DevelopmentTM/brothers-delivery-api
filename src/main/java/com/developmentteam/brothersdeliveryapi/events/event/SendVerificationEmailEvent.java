package com.developmentteam.brothersdeliveryapi.events.event;

import com.developmentteam.brothersdeliveryapi.entities.auth.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.util.UriComponentsBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SendVerificationEmailEvent  {

   private User user;
   private UriComponentsBuilder uriComponentsBuilder;

   public static SendVerificationEmailEvent createEvent(User user, UriComponentsBuilder uriComponentsBuilder) {
      return new SendVerificationEmailEvent(user, uriComponentsBuilder);
   }

}
