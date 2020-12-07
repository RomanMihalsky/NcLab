package com.nc.mihalsky.openers.validators.errors;

public class DiscrepancyPatternException extends RuntimeException{
  public DiscrepancyPatternException(String message){
    super(message);
  }

  public DiscrepancyPatternException(String message,Throwable cause){
    super(message,cause);
  }

  public DiscrepancyPatternException(Throwable cause){
    super(cause);
  }
}
