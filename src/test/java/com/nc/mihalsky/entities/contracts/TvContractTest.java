package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.contracts.enums.TvTariff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class TvContractTest {
  TvContract tvContract;

  @BeforeEach
  void init () {
    tvContract = new TvContract();
  }

  @Test
  void getTariff() throws NoSuchFieldException, IllegalAccessException{
    Field field = tvContract.getClass().getDeclaredField("tariff");
    field.setAccessible(true);
    field.set(tvContract, TvTariff.SMALL);

    TvTariff result = tvContract.getTariff();

    assertEquals(TvTariff.SMALL,result,"Fields didn't match");
  }

  @Test
  void setTariff() throws NoSuchFieldException, IllegalAccessException{
    tvContract.setTariff(TvTariff.SMALL);

    Field field = tvContract.getClass().getDeclaredField("tariff");
    field.setAccessible(true);

    assertEquals(TvTariff.SMALL,field.get(tvContract),"Fields didn't match");
  }

  @Test
  void testToString() {
    assertEquals(
            "TvContract{tariff=TvTariff{channelsAmount=10}," +
            " id=0," +
            " dateStartOfUse=1900-01-01," +
            " dateEndOfUse=1900-01-01," +
            " client=0}",
            tvContract.toString(),
            "Fields didn't match");
  }
}