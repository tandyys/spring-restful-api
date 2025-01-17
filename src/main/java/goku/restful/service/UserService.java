package goku.restful.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import goku.restful.dto.UserRegisterRequest;
import goku.restful.entity.User;
import goku.restful.repository.UserRepository;
import goku.restful.security.BCrypt;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

@Service
public class UserService {

      @Autowired
      private UserRepository userRepository;

      @Autowired
      private Validator validator;

      @Transactional
      public void register(UserRegisterRequest request) {
            Set<ConstraintViolation<UserRegisterRequest>> constraintViolations = validator.validate(request);
            if (constraintViolations.size() != 0) {
                  throw new ConstraintViolationException(constraintViolations);
            }

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
