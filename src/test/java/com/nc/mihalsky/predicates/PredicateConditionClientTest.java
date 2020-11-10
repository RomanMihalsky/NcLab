package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.factories.FactoryClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PredicateConditionClientTest {
  PredicateConditionClient predicateConditionClient;

  @BeforeEach
  void init(){
    predicateConditionClient = new PredicateConditionClient(FactoryClient.createClient());
  }

  @Test
  void setClient() throws NoSuchFieldException, IllegalAccessException {
    Client expectedClient = FactoryClient.createClient();
    predicateConditionClient.setClient(expectedClient);

    Field field = predicateConditionClient.getClass().getDeclaredField("client");
    field.setAccessible(true);

    assertEquals(expectedClient,field.get(predicateConditionClient),"Fields didn't match");
  }
}