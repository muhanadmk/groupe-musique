package utile;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TokenHelper {
  /**
   * LOGGER.
   */
  private static final Logger LOGGER = Logger.getLogger(
      TokenHelper.class.getName());

  public TokenHelper(){}
  private static final SecureRandom secureRandom = new SecureRandom(); 
  private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); 
  private static  String c_token = null;

  private static String p_token = null;

  public static String getC_token() {
    try {
      byte[] randomBytes = new byte[24];
      secureRandom.nextBytes(randomBytes);
      c_token =  base64Encoder.encodeToString(randomBytes);
      p_token = c_token;
    } catch (Exception e) {
      LOGGER.warning(e.getMessage());
    }
    return c_token;
  }

  public static String get_tokenComapar() {
    return p_token;
  }
}