package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.enums.TvTariff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PredicateConditionTvTariffTest {
  PredicateConditionTvTariff predicateConditionTvTariff;

  @BeforeEach
  void init(){
    predicateConditionTvTariff = new PredicateConditionTvTariff(TvTariff.SMALL);
  }

  @Test
  void setClient() throws NoSuchFieldException, IllegalAccessException {
    TvTariff tvTariffExpected = TvTariff.SMALL;
    predicateConditionTvTariff.setTvTariff(TvTariff.SMALL);

    Field field = predicateConditionTvTariff.getClass().getDeclaredField("tvTariff");
    field.setAccessible(true);

    assertEquals(tvTariffExpected,field.get(predicateConditionTvTariff),"Fields didn't match");
  }
}