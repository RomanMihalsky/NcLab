package com.nc.mihalsky.openers.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PatternPatronymicTest {
  PatternPatronymic patternPatronymic;
  @BeforeEach
  void init(){
    patternPatronymic = new PatternPatronymic();
  }

  @Test
  void getTitle(){
    String result = patternPatronymic.getTitle();

    assertEquals("patronymic",result,"Fields didn't match");
  }

  @Test
  void getIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    Field field = patternPatronymic.getClass().getDeclaredField("indexPatronymic");
    field.setAccessible(true);
    field.set(patternPatronymic,1);

    int result = patternPatronymic.getIndexOfTitle();

    assertEquals(1,result,"Fields didn't match");
  }

  @Test
  void setIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    patternPatronymic.setIndexOfTitle(1);

    Field field = patternPatronymic.getClass().getDeclaredField("indexPatronymic");
    field.setAccessible(true);

    assertEquals(1,field.get(patternPatronymic),"Fields didn't match");
  }
}