package com.nc.mihalsky.openers.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PatternCondition1Test {
  PatternCondition1 patternCondition1;
  @BeforeEach
  void init(){
   patternCondition1 = new PatternCondition1();
  }

  @Test
  void getTitle(){
    String result = patternCondition1.getTitle();

    assertEquals("condition1",result,"Fields didn't match");
  }

  @Test
  void getIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    Field field = patternCondition1.getClass().getDeclaredField("indexCondition1");
    field.setAccessible(true);
    field.set(patternCondition1,1);

    int result = patternCondition1.getIndexOfTitle();

    assertEquals(1,result,"Fields didn't match");
  }

  @Test
  void setIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    patternCondition1.setIndexOfTitle(1);

    Field field = patternCondition1.getClass().getDeclaredField("indexCondition1");
    field.setAccessible(true);

    assertEquals(1,field.get(patternCondition1),"Fields didn't match");
  }
}