package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.enums.MobileTariff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PredicateConditionMobileTariffTest {
  PredicateConditionMobileTariff predicateConditionMobileTariff;

  @BeforeEach
  void init(){
    predicateConditionMobileTariff = new PredicateConditionMobileTariff(MobileTariff.CHEAP);
  }

  @Test
  void setClient() throws NoSuchFieldException, IllegalAccessException {
    MobileTariff mobileTariffExpected = MobileTariff.CHEAP;
    predicateConditionMobileTariff.setMobileTariff(MobileTariff.CHEAP);

    Field field = predicateConditionMobileTariff.getClass().getDeclaredField("mobileTariff");
    field.setAccessible(true);

    assertEquals(mobileTariffExpected,field.get(predicateConditionMobileTariff),"Fields didn't match");
  }
}