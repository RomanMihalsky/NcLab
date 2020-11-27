package com.nc.mihalsky.openers.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PatternPhoneNumberTest {
  PatternPhoneNumber patternPhoneNumber;
  @BeforeEach
  void init(){
    patternPhoneNumber = new PatternPhoneNumber();
  }

  @Test
  void getTitle(){
    String result = patternPhoneNumber.getTitle();

    assertEquals("phoneNumber",result,"Fields didn't match");
  }

  @Test
  void getIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    Field field = patternPhoneNumber.getClass().getDeclaredField("indexPhoneNumber");
    field.setAccessible(true);
    field.set(patternPhoneNumber,1);

    int result = patternPhoneNumber.getIndexOfTitle();

    assertEquals(1,result,"Fields didn't match");
  }

  @Test
  void setIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    patternPhoneNumber.setIndexOfTitle(1);

    Field field = patternPhoneNumber.getClass().getDeclaredField("indexPhoneNumber");
    field.setAccessible(true);

    assertEquals(1,field.get(patternPhoneNumber),"Fields didn't match");
  }
}