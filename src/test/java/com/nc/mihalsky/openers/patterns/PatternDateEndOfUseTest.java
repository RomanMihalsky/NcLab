package com.nc.mihalsky.openers.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PatternDateEndOfUseTest {
  PatternDateEndOfUse patternDateEndOfUse;
  @BeforeEach
  void init(){
    patternDateEndOfUse = new PatternDateEndOfUse();
  }

  @Test
  void getTitle(){
    String result = patternDateEndOfUse.getTitle();

    assertEquals("dateEndOfUse",result,"Fields didn't match");
  }

  @Test
  void getIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    Field field = patternDateEndOfUse.getClass().getDeclaredField("indexDateEndOfUse");
    field.setAccessible(true);
    field.set(patternDateEndOfUse,1);

    int result = patternDateEndOfUse.getIndexOfTitle();

    assertEquals(1,result,"Fields didn't match");
  }

  @Test
  void setIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    patternDateEndOfUse.setIndexOfTitle(1);

    Field field = patternDateEndOfUse.getClass().getDeclaredField("indexDateEndOfUse");
    field.setAccessible(true);

    assertEquals(1,field.get(patternDateEndOfUse),"Fields didn't match");
  }
}