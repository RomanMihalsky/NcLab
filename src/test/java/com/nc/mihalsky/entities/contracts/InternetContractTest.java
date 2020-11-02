package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.contracts.enums.InternetTariff;
import com.nc.mihalsky.entities.persons.Client;
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
  void testToString() throws NoSuchFieldException, IllegalAccessException {
    Field fieldTariff = internetContract.getClass().getDeclaredField("tariff");
    fieldTariff.setAccessible(true);
    Field fieldId = Contract.class.getDeclaredField("id");
    fieldId.setAccessible(true);
    Field fieldDateStartOfUse = Contract.class.getDeclaredField("dateStartOfUse");
    fieldDateStartOfUse.setAccessible(true);
    Field fieldDateEndOfUse = Contract.class.getDeclaredField("dateEndOfUse");
    fieldDateEndOfUse.setAccessible(true);

    Field fieldClient = Contract.class.getDeclaredField("client");
    fieldClient.setAccessible(true);

    Field fieldClientId = ((Client)fieldClient.get(internetContract)).getClass().getDeclaredField("id");
    fieldClientId.setAccessible(true);


    assertEquals("InternetContract{tariff="+fieldTariff.get(internetContract)+"," +
            " id="+ fieldId.get(internetContract)+"," +
            " dateStartOfUse="+ fieldDateStartOfUse.get(internetContract) +"," +
            " dateEndOfUse="+ fieldDateEndOfUse.get(internetContract) +"," +
            " client="+ fieldClientId.get(((Client)fieldClient.get(internetContract))) +"}",
            internetContract.toString(),
            "Fields didn't match");
  }
}