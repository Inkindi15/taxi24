package com.bkcoding.taxi24.exceptions;

public class ValidationException extends RuntimeException {
  public ValidationException(String errorMessage) {
    super(errorMessage);
  }
}
