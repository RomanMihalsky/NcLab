package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.contracts.enums.InternetTariff;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.factories.FactoryClient;
import com.nc.mihalsky.factories.FactoryContract;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorPatronymicTest {

  ValidatorPatronymic validatorPatronymic;
  Client client;
  Contract contract;

  @BeforeEach
  void init(){
    validatorPatronymic = new ValidatorPatronymic();
    client = FactoryClient.createClient("Roman","Mihalsky","Alex","man",12345678912L,1212,123123,new LocalDate(2020,10,10));
    FactoryContract factoryContract = new FactoryContract();
    contract = factoryContract.createInternetContract(new LocalDate(2000,10,10),new LocalDate(2020,11,11),client, InternetTariff.MEGAS);
  }

  @Test
  void validateOk() throws NoSuchFieldException, IllegalAccessException {
    PatternError patternError = validatorPatronymic.validate(contract);

    Field field = patternError.getClass().getDeclaredField("status");
    field.setAccessible(true);


    assertEquals(Status.OK,field.get(patternError),"Fields didn't match");
  }

  @Test
  void validateError() throws NoSuchFieldException, IllegalAccessException {
    Field fieldDate = client.getClass().getDeclaredField("patronymic");
    fieldDate.setAccessible(true);

    fieldDate.set(client,"123");

    PatternError patternError = validatorPatronymic.validate(contract);

    Field field = patternError.getClass().getDeclaredField("status");
    field.setAccessible(true);


    assertEquals(Status.ERROR,field.get(patternError),"Fields didn't match");
  }
}