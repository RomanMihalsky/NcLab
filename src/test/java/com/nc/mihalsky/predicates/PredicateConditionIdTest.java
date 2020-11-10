package com.nc.mihalsky.predicates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PredicateConditionIdTest {
  PredicateConditionId predicateConditionID;

  @BeforeEach
  void init(){
    predicateConditionID = new PredicateConditionId(1);
  }

  @Test
  void setClient() throws NoSuchFieldException, IllegalAccessException {
    predicateConditionID.setId(2L);

    Field field = predicateConditionID.getClass().getDeclaredField("id");
    field.setAccessible(true);

    assertEquals(2L,field.get(predicateConditionID),"Fields didn't match");
  }
}