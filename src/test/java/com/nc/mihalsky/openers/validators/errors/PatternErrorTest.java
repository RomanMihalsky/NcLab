package com.nc.mihalsky.openers.validators.errors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PatternErrorTest {
  PatternError patternError;
  long time;
  @BeforeEach
  void init(){
    time = System.currentTimeMillis();
    patternError = new PatternError(Status.OK,"Everything OK",time);
  }

  @Test
  void getStatus() {
    Status result = patternError.getStatus();
    assertEquals(Status.OK,result,"Fields didn't match");
  }

  @Test
  void setStatus() throws NoSuchFieldException, IllegalAccessException {
    patternError.setStatus(Status.ERROR);

    Field field = patternError.getClass().getDeclaredField("status");
    field.setAccessible(true);

    assertEquals(Status.ERROR,field.get(patternError),"Fields didn't match");
  }

  @Test
  void getMessage() {
    String message = patternError.getMessage();
    assertEquals("Everything OK",message,"Fields didn't match");
  }

  @Test
  void setMessage() throws NoSuchFieldException, IllegalAccessException {
    patternError.setMessage("Good Luck");

    Field field = patternError.getClass().getDeclaredField("message");
    field.setAccessible(true);

    assertEquals("Good Luck",field.get(patternError),"Fields didn't match");
  }

  @Test
  void getTimeStamp() {
    assertEquals(time,patternError.getTimeStamp(),"Fields didn't match");
  }

  @Test
  void setTimeStamp() throws NoSuchFieldException, IllegalAccessException {
    long result = System.currentTimeMillis();
    patternError.setTimeStamp(result);

    Field field = patternError.getClass().getDeclaredField("timeStamp");
    field.setAccessible(true);

    assertEquals(result,field.get(patternError),"Fields didn't match");
  }

  @Test
  void testToString() {
    assertEquals("PatternError{status=OK, message='Everything OK', timeStamp="+time+"}",patternError.toString(),"Fields didn't match");
  }
}