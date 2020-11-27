package com.nc.mihalsky.openers.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PatternPassportSeriesTest {
  PatternPassportSeries patternPassportSeries;
  @BeforeEach
  void init(){
    patternPassportSeries = new PatternPassportSeries();
  }

  @Test
  void getTitle(){
    String result = patternPassportSeries.getTitle();

    assertEquals("passportSeries",result,"Fields didn't match");
  }

  @Test
  void getIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    Field field = patternPassportSeries.getClass().getDeclaredField("indexPassportSeries");
    field.setAccessible(true);
    field.set(patternPassportSeries,1);

    int result = patternPassportSeries.getIndexOfTitle();

    assertEquals(1,result,"Fields didn't match");
  }

  @Test
  void setIndexOfTitle() throws NoSuchFieldException, IllegalAccessException {
    patternPassportSeries.setIndexOfTitle(1);

    Field field = patternPassportSeries.getClass().getDeclaredField("indexPassportSeries");
    field.setAccessible(true);

    assertEquals(1,field.get(patternPassportSeries),"Fields didn't match");
  }
}