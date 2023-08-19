package com.developmentteam.brothersdeliveryapi.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
public class UrlUtils {

   private UrlUtils() {}

   public static UriComponentsBuilder getRedirectLink(String path) {
      return ServletUriComponentsBuilder.fromCurrentContextPath()
              .path(path);
   }

   public static String addParametersToUrl(UriComponentsBuilder url, String token) {
      return url.queryParam("token", token).toUriString()
              .replace("localhost", getIpAddress());
   }

   public static String getIpAddress() {
      try {
         return InetAddress.getLocalHost().getHostAddress();
      } catch (UnknownHostException e) {
         log.warn("could not find IpAddress");
         return "localhost";
      }
   }

}
