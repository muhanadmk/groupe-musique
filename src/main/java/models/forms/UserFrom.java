package models.forms;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.logging.Logger;

public class UserFrom {
  /**
   * LOGGER.
   */
  private static final Logger LOGGER = Logger.getLogger(
    UserFrom.class.getName());
    
  public static String getSecurePassword(String password, String salt) {
    String toReturn = null;
    try {
      String appSecret = System.getenv("appSecret");
      String input = salt + password + appSecret;
      MessageDigest digest = MessageDigest.getInstance("SHA-512");
      digest.reset();
      digest.update(input.getBytes("utf8"));
      toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
    } catch (Exception e) {
      LOGGER.warning(e.getMessage());
    }
    return toReturn;
  }

  public static String getSalt() {
    try {
      SecureRandom random = new SecureRandom();
      byte[] salt = new byte[30];
      random.nextBytes(salt);
      return salt.toString();
    } catch (Exception e) {
      LOGGER.warning(e.getMessage());
      return null;
    }
  }
}
