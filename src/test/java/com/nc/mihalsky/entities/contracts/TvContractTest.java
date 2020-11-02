package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.contracts.enums.TvTariff;
import com.nc.mihalsky.entities.persons.Client;
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
  void testToString() throws NoSuchFieldException, IllegalAccessException {
    Field fieldTariff = tvContract.getClass().getDeclaredField("tariff");
    fieldTariff.setAccessible(true);
    Field fieldId = Contract.class.getDeclaredField("id");
    fieldId.setAccessible(true);
    Field fieldDateStartOfUse = Contract.class.getDeclaredField("dateStartOfUse");
    fieldDateStartOfUse.setAccessible(true);
    Field fieldDateEndOfUse = Contract.class.getDeclaredField("dateEndOfUse");
    fieldDateEndOfUse.setAccessible(true);

    Field fieldClient = Contract.class.getDeclaredField("client");
    fieldClient.setAccessible(true);

    Field fieldClientId = ((Client)fieldClient.get(tvContract)).getClass().getDeclaredField("id");
    fieldClientId.setAccessible(true);


    assertEquals("TvContract{tariff="+fieldTariff.get(tvContract)+"," +
                    " id="+ fieldId.get(tvContract)+"," +
                    " dateStartOfUse="+ fieldDateStartOfUse.get(tvContract) +"," +
                    " dateEndOfUse="+ fieldDateEndOfUse.get(tvContract) +"," +
                    " client="+ fieldClientId.get(((Client)fieldClient.get(tvContract))) +"}",
            tvContract.toString(),
            "Fields didn't match");
  }
}