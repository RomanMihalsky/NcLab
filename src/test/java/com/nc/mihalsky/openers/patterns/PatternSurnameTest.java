package com.nc.mihalsky.openers.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PatternSurnameTest {
  PatternSurname patternSurname;
  @BeforeEach
  void init(){
    patternSurname = new PatternSurname();
  }

  @Test
  void getTitle(){
    String result = patternSurname.getTitle();

    assertEquals("surname",result,"Fields didn't match");
  }

  @Test
  void getIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    Field field = patternSurname.getClass().getDeclaredField("indexSurname");
    field.setAccessible(true);
    field.set(patternSurname,1);

    int result = patternSurname.getIndexOfTitle();

    assertEquals(1,result,"Fields didn't match");
  }

  @Test
  void setIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    patternSurname.setIndexOfTitle(1);

    Field field = patternSurname.getClass().getDeclaredField("indexSurname");
    field.setAccessible(true);

    assertEquals(1,field.get(patternSurname),"Fields didn't match");
  }
}