package com.developmentteam.brothersdeliveryapi.utils;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class RandomUtils {

   private RandomUtils() {}

   public static String generateRandomToken() {
      byte[] bytes = new byte[32];

      SecureRandom random = new SecureRandom();
      random.nextBytes(bytes);

      return Base64.getEncoder()
              .encodeToString(bytes)
              .replaceAll("[^A-Za-z0-9]", "X");
   }

   public static Integer generateResetCode() {
      Random random = new Random();
      return random.nextInt(899999) + 100000;
   }

}
