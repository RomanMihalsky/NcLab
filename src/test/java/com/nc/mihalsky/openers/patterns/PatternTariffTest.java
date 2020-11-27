package com.nc.mihalsky.openers.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PatternTariffTest {
  PatternTariff patternTariff;
  @BeforeEach
  void init(){
    patternTariff = new PatternTariff();
  }

  @Test
  void getTitle(){
    String result = patternTariff.getTitle();

    assertEquals("tariff",result,"Fields didn't match");
  }

  @Test
  void getIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    Field field = patternTariff.getClass().getDeclaredField("indexTariff");
    field.setAccessible(true);
    field.set(patternTariff,1);

    int result = patternTariff.getIndexOfTitle();

    assertEquals(1,result,"Fields didn't match");
  }

  @Test
  void setIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    patternTariff.setIndexOfTitle(1);

    Field field = patternTariff.getClass().getDeclaredField("indexTariff");
    field.setAccessible(true);

    assertEquals(1,field.get(patternTariff),"Fields didn't match");
  }
}