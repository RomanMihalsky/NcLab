package com.nc.mihalsky.openers.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PatternDateOfBirthDayTest {
  PatternDateOfBirthDay patternDateOfBirthDay;
  @BeforeEach
  void init(){
    patternDateOfBirthDay = new PatternDateOfBirthDay();
  }

  @Test
  void getTitle(){
    String result = patternDateOfBirthDay.getTitle();

    assertEquals("dateOfBirthDay",result,"Fields didn't match");
  }

  @Test
  void getIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    Field field = patternDateOfBirthDay.getClass().getDeclaredField("indexDateOfBirthDay");
    field.setAccessible(true);
    field.set(patternDateOfBirthDay,1);

    int result = patternDateOfBirthDay.getIndexOfTitle();

    assertEquals(1,result,"Fields didn't match");
  }

  @Test
  void setIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    patternDateOfBirthDay.setIndexOfTitle(1);

    Field field = patternDateOfBirthDay.getClass().getDeclaredField("indexDateOfBirthDay");
    field.setAccessible(true);

    assertEquals(1,field.get(patternDateOfBirthDay),"Fields didn't match");
  }
}