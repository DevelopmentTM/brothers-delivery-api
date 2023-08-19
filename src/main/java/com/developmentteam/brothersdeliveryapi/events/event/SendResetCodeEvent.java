package com.developmentteam.brothersdeliveryapi.events.event;

import com.developmentteam.brothersdeliveryapi.entities.auth.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SendResetCodeEvent {

   private User user;

   public static SendResetCodeEvent createEvent(User user) {
      return new SendResetCodeEvent(user);
   }

}