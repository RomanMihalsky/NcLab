package com.nc.mihalsky.openers.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PatternPassportNumberTest {
  PatternPassportNumber patternPassportNumber;
  @BeforeEach
  void init(){
    patternPassportNumber = new PatternPassportNumber();
  }

  @Test
  void getTitle(){
    String result = patternPassportNumber.getTitle();

    assertEquals("passportNumber",result,"Fields didn't match");
  }

  @Test
  void getIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    Field field = patternPassportNumber.getClass().getDeclaredField("indexPassportNumber");
    field.setAccessible(true);
    field.set(patternPassportNumber,1);

    int result = patternPassportNumber.getIndexOfTitle();

    assertEquals(1,result,"Fields didn't match");
  }

  @Test
  void setIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    patternPassportNumber.setIndexOfTitle(1);

    Field field = patternPassportNumber.getClass().getDeclaredField("indexPassportNumber");
    field.setAccessible(true);

    assertEquals(1,field.get(patternPassportNumber),"Fields didn't match");
  }
}