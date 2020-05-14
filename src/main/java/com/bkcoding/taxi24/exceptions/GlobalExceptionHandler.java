package com.bkcoding.taxi24.exceptions;

import com.bkcoding.taxi24.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  /** {@link ValidationException} is thrown when there is a validation error <br> */
  @ExceptionHandler({ValidationException.class, UniqueConstraintException.class})
  public ResponseEntity<Object> handleErrors(Exception ex) {

    final String errorMessage = ex.getMessage();
    ApiResponse<Void> body = new ApiResponse<>(HttpStatus.BAD_REQUEST, errorMessage, null);

    log.error(errorMessage);
    return ResponseEntity.badRequest().body(body);
  }

  @ExceptionHandler({NotFoundException.class})
  public ResponseEntity<Object> handleNotFoundException(Exception ex) {

    final String errorMessage = ex.getMessage();
    ApiResponse<Void> body = new ApiResponse<>(HttpStatus.NOT_FOUND, errorMessage, null);

    log.error(errorMessage);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
  }
}
