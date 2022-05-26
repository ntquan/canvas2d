package com.canvas2d.exception;

public class InvalidInputException extends Exception {
   public InvalidInputException(String msg) {
      super(msg);
   }

   public InvalidInputException(String msg, Throwable cause) {
      super(msg, cause);
   }
}
