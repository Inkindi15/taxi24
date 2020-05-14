package com.bkcoding.taxi24.exceptions;

public class UniqueConstraintException extends RuntimeException {
  public UniqueConstraintException(String message) {
    super(message);
  }
}
