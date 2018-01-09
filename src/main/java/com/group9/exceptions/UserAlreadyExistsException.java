package com.group9.exceptions;

public class UserAlreadyExistsException extends Exception
{
  public UserAlreadyExistsException(String message)
  {
    super(message);
  }
}