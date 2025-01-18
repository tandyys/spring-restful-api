package goku.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import goku.restful.dto.SessionTokenResponse;
import goku.restful.dto.UserLoginRequest;
import goku.restful.dto.UserRegisterRequest;
import goku.restful.dto.WebResponse;
import goku.restful.service.AuthService;
import goku.restful.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
      @Autowired
      private UserService userService;

      @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
      public WebResponse<String> register(@RequestBody UserRegisterRequest request) {
            userService.register(request);
            return WebResponse.<String>builder().data("OK!").build();
      }

      @Autowired
      private AuthService authService;

      @PostMapping(path = "/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
      public WebResponse<SessionTokenResponse> login(@RequestBody UserLoginRequest request) {
            SessionTokenResponse response = authService.login(request);
            return WebResponse.<SessionTokenResponse>builder().data(response).build();
      }
}
