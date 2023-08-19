package com.developmentteam.brothersdeliveryapi.events.publisher;

import com.developmentteam.brothersdeliveryapi.events.event.SendResetCodeEvent;
import com.developmentteam.brothersdeliveryapi.events.event.SendVerificationEmailEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class NotificationPublisher implements ApplicationEventPublisherAware {

   private ApplicationEventPublisher applicationEventPublisher;

   public void onSendVerificationEmail(SendVerificationEmailEvent event) {
      this.applicationEventPublisher.publishEvent(event);
   }

   public void onSendResetCode(SendResetCodeEvent event) {
      this.applicationEventPublisher.publishEvent(event);
   }

   @Autowired
   @Override
   public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
      this.applicationEventPublisher = applicationEventPublisher;
   }
}
