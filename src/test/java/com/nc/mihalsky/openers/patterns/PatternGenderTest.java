package com.nc.mihalsky.openers.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PatternGenderTest {
  PatternGender patternGender;
  @BeforeEach
  void init(){
    patternGender = new PatternGender();
  }

  @Test
  void getTitle(){
    String result = patternGender.getTitle();

    assertEquals("gender",result,"Fields didn't match");
  }

  @Test
  void getIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    Field field = patternGender.getClass().getDeclaredField("indexGender");
    field.setAccessible(true);
    field.set(patternGender,1);

    int result = patternGender.getIndexOfTitle();

    assertEquals(1,result,"Fields didn't match");
  }

  @Test
  void setIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    patternGender.setIndexOfTitle(1);

    Field field = patternGender.getClass().getDeclaredField("indexGender");
    field.setAccessible(true);

    assertEquals(1,field.get(patternGender),"Fields didn't match");
  }
}