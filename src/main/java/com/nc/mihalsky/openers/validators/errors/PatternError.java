package com.nc.mihalsky.openers.validators.errors;

public class PatternError {
  private Status status;
  private String message;
  private long timeStamp;

  public PatternError(){
    this.status = Status.OK;
    this.message = "OK";
    this.timeStamp = System.currentTimeMillis();
  }

  public PatternError(Status status, String message, long timeStamp) {
    this.status = status;
    this.message = message;
    this.timeStamp = timeStamp;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public long getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
  }

  @Override
  public String toString() {
    return "PatternError{" +
            "status=" + status +
            ", message='" + message + '\'' +
            ", timeStamp=" + timeStamp +
            '}';
  }
}
