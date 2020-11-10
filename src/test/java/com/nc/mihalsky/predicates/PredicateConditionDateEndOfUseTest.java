package com.nc.mihalsky.predicates;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PredicateConditionDateEndOfUseTest {
  PredicateConditionDateEndOfUse predicateConditionDateEndOfUse;

  @BeforeEach
  void init(){
    predicateConditionDateEndOfUse = new PredicateConditionDateEndOfUse(new LocalDate(2000,1,1));
  }

  @Test
  void setClient() throws NoSuchFieldException, IllegalAccessException {
    LocalDate localDateExpected = new LocalDate(2005,1,1);
    predicateConditionDateEndOfUse.setDateEndOfUse(localDateExpected);

    Field field = predicateConditionDateEndOfUse.getClass().getDeclaredField("dateEndOfUse");
    field.setAccessible(true);

    assertEquals(localDateExpected,field.get(predicateConditionDateEndOfUse),"Fields didn't match");
  }
}