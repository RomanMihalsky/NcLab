package com.nc.mihalsky.predicates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PredicateConditionClientIdTest {
  PredicateConditionClientId predicateConditionClientID;

  @BeforeEach
  void init(){
    predicateConditionClientID = new PredicateConditionClientId(1);
  }

  @Test
  void setClient() throws NoSuchFieldException, IllegalAccessException {
    predicateConditionClientID.setClientId(2L);

    Field field = predicateConditionClientID.getClass().getDeclaredField("clientId");
    field.setAccessible(true);

    assertEquals(2L,field.get(predicateConditionClientID),"Fields didn't match");
  }
}