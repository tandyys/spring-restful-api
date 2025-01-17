package goku.restful.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import goku.restful.dto.WebResponse;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorController {

      @ExceptionHandler(ConstraintViolationException.class)
      public ResponseEntity<WebResponse<String>> constraintViolationException(ConstraintViolationException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(WebResponse.<String>builder().error(exception.getMessage()).build());
      }

      @ExceptionHandler(ResponseStatusException.class)
      public ResponseEntity<WebResponse<String>> responseException(ResponseStatusException exception) {
            return ResponseEntity.status(exception.getStatusCode())
            .body(WebResponse.<String>builder().error(exception.getReason()).build());
      }
}
