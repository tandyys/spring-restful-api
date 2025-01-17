package goku.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import goku.restful.dto.UserRegisterRequest;
import goku.restful.entity.User;
import goku.restful.repository.UserRepository;
import goku.restful.security.BCrypt;
import jakarta.transaction.Transactional;

@Service
public class UserService {

      @Autowired
      private UserRepository userRepository;

      @Autowired
      private ValidationService validationService;

      @Transactional
      public void register(UserRegisterRequest request) {
            validationService.validate(request);

            if (userRepository.existsById(request.getEmail())) {
                  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists!");
            }

            User user = new User();
            user.setEmail(request.getEmail());
            user.setUsername(request.getUsername());
            user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));

            userRepository.save(user);
      }
}
