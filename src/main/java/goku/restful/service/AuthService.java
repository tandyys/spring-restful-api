package goku.restful.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import goku.restful.dto.SessionTokenResponse;
import goku.restful.dto.UserLoginRequest;
import goku.restful.entity.User;
import goku.restful.repository.UserRepository;
import goku.restful.security.BCrypt;
import jakarta.transaction.Transactional;

@Service
public class AuthService {
      @Autowired
      UserRepository userRepository;

      @Autowired
      ValidationService validationService;

      @Transactional
      public SessionTokenResponse login(UserLoginRequest request) {
            validationService.validate(request);

            User user = userRepository.findById(request.getEmail())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                                    "Invalid email or password!"));

            if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
                  user.setToken(UUID.randomUUID().toString());
                  user.setTokenExpiredAt(generateExpiredAt());
                  userRepository.save(user);

                  return SessionTokenResponse.builder()
                              .token(user.getToken())
                              .expiredAt(user.getTokenExpiredAt())
                              .build();
            } else {
                  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password!");
            }
      }

      private Long generateExpiredAt() {
            return System.currentTimeMillis() + (1000 * 60 * 60 * 24);
      }
}
