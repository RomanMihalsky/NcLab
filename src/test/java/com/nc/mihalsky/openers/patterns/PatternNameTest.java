package com.nc.mihalsky.openers.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PatternNameTest {
  PatternName patternName;
  @BeforeEach
  void init(){
    patternName = new PatternName();
  }

  @Test
  void getTitle(){
    String result = patternName.getTitle();

    assertEquals("name",result,"Fields didn't match");
  }

  @Test
  void getIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    Field field = patternName.getClass().getDeclaredField("indexName");
    field.setAccessible(true);
    field.set(patternName,1);

    int result = patternName.getIndexOfTitle();

    assertEquals(1,result,"Fields didn't match");
  }

  @Test
  void setIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    patternName.setIndexOfTitle(1);

    Field field = patternName.getClass().getDeclaredField("indexName");
    field.setAccessible(true);

    assertEquals(1,field.get(patternName),"Fields didn't match");
  }
}