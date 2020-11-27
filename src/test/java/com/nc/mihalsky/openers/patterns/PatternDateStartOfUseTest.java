package com.nc.mihalsky.openers.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PatternDateStartOfUseTest {
  PatternDateStartOfUse patternDateStartOfUse;
  @BeforeEach
  void init(){
    patternDateStartOfUse = new PatternDateStartOfUse();
  }

  @Test
  void getTitle(){
    String result = patternDateStartOfUse.getTitle();

    assertEquals("dateStartOfUse",result,"Fields didn't match");
  }

  @Test
  void getIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    Field field = patternDateStartOfUse.getClass().getDeclaredField("indexDateStartOfUse");
    field.setAccessible(true);
    field.set(patternDateStartOfUse,1);

    int result = patternDateStartOfUse.getIndexOfTitle();

    assertEquals(1,result,"Fields didn't match");
  }

  @Test
  void setIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    patternDateStartOfUse.setIndexOfTitle(1);

    Field field = patternDateStartOfUse.getClass().getDeclaredField("indexDateStartOfUse");
    field.setAccessible(true);

    assertEquals(1,field.get(patternDateStartOfUse),"Fields didn't match");
  }
}