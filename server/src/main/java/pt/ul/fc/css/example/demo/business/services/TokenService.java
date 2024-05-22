package pt.ul.fc.css.example.demo.business.services;

import java.security.SecureRandom;
import java.util.Base64;
import org.springframework.stereotype.Service;

/**
 * This class reprents the Token Service. Responsible to generate a token for the user
 *
 * @author Joao Miguel
 * @author Guilherme Gouveia
 * @author Rafael Correia
 */
@Service
public class TokenService {

  private final SecureRandom secureRandom = new SecureRandom();
  private final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

  public String generateToken() {
    byte[] randomBytes = new byte[24];
    secureRandom.nextBytes(randomBytes);
    return base64Encoder.encodeToString(randomBytes);
  }
}
