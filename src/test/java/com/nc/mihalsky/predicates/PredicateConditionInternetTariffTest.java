package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.enums.InternetTariff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PredicateConditionInternetTariffTest {
  PredicateConditionInternetTariff predicateConditionInternetTariff;

  @BeforeEach
  void init(){
    predicateConditionInternetTariff = new PredicateConditionInternetTariff(InternetTariff.MEGAS);
  }

  @Test
  void setClient() throws NoSuchFieldException, IllegalAccessException {
    InternetTariff internetTariffExpected = InternetTariff.MEGAS;
    predicateConditionInternetTariff.setInternetTariff(internetTariffExpected);

    Field field = predicateConditionInternetTariff.getClass().getDeclaredField("internetTariff");
    field.setAccessible(true);

    assertEquals(internetTariffExpected,field.get(predicateConditionInternetTariff),"Fields didn't match");
  }
}