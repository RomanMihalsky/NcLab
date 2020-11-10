package com.nc.mihalsky.predicates;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PredicateConditionDateStartOfUseTest {
  PredicateConditionDateStartOfUse predicateConditionDateStartOfUse;

  @BeforeEach
  void init(){
    predicateConditionDateStartOfUse = new PredicateConditionDateStartOfUse(new LocalDate(2000,1,1));
  }

  @Test
  void setClient() throws NoSuchFieldException, IllegalAccessException {
    LocalDate localDateExpected = new LocalDate(2005,1,1);
    predicateConditionDateStartOfUse.setDateStartOfUse(localDateExpected);

    Field field = predicateConditionDateStartOfUse.getClass().getDeclaredField("dateStartOfUse");
    field.setAccessible(true);

    assertEquals(localDateExpected,field.get(predicateConditionDateStartOfUse),"Fields didn't match");
  }
}