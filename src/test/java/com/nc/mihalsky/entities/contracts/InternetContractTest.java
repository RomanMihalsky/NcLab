package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.contracts.enums.InternetTariff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class InternetContractTest {
  InternetContract internetContract;

  @BeforeEach
  void init (){
    internetContract = new InternetContract();
  }

  @Test
  void getTariff() throws NoSuchFieldException, IllegalAccessException{
    Field field = internetContract.getClass().getDeclaredField("tariff");
    field.setAccessible(true);
    field.set(internetContract, InternetTariff.MEGAS);

    InternetTariff result = internetContract.getTariff();

    assertEquals(InternetTariff.MEGAS,result,"Fields didn't match");
  }

  @Test
  void setTariff() throws NoSuchFieldException, IllegalAccessException{
    internetContract.setTariff(InternetTariff.MEGAS);

    Field field = internetContract.getClass().getDeclaredField("tariff");
    field.setAccessible(true);

    assertEquals(InternetTariff.MEGAS,field.get(internetContract),"Fields didn't match");
  }

  @Test
  void testToString() {
    assertEquals("InternetContract{tariff=InternetTariff{internetSpeed=75}," +
            " id=0," +
            " dateStartOfUse=1900-01-01," +
            " dateEndOfUse=1900-01-01," +
            " client=0}",
            internetContract.toString(),
            "Fields didn't match");
  }
}