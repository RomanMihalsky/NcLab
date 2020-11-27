package com.nc.mihalsky.openers.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PatternCondition2Test {
  PatternCondition2 patternCondition2;
  @BeforeEach
  void init(){
    patternCondition2 = new PatternCondition2();
  }

  @Test
  void getTitle(){
    String result = patternCondition2.getTitle();

    assertEquals("condition2",result,"Fields didn't match");
  }

  @Test
  void getIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    Field field = patternCondition2.getClass().getDeclaredField("indexCondition2");
    field.setAccessible(true);
    field.set(patternCondition2,1);

    int result = patternCondition2.getIndexOfTitle();

    assertEquals(1,result,"Fields didn't match");
  }

  @Test
  void setIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    patternCondition2.setIndexOfTitle(1);

    Field field = patternCondition2.getClass().getDeclaredField("indexCondition2");
    field.setAccessible(true);

    assertEquals(1,field.get(patternCondition2),"Fields didn't match");
  }
}