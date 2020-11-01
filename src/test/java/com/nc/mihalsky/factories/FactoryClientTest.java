package com.nc.mihalsky.factories;

import com.nc.mihalsky.entities.persons.Client;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryClientTest {

  @Test
  void createClient() {
    Client clientExpected = FactoryClient.createClient();
    clientExpected.setId(clientExpected.getId()+1);

    Client clientActual = FactoryClient.createClient();

    assertEquals(clientExpected,clientActual,"Fields didn't match");
  }

  @Test
  void testCreateClient() {
    Client clientExpected = FactoryClient.createClient("Roman",
            "Mihalsky","Alex","men",123123123,123123,123123,new LocalDate(1999,10,12));
    clientExpected.setId(clientExpected.getId()+1);

    Client clientActual = FactoryClient.createClient("Roman",
            "Mihalsky","Alex","men",123123123,123123,123123,new LocalDate(1999,10,12));

    assertEquals(clientExpected,clientActual,"Fields didn't match");
  }

  @Test
  void testCreateClientWithNull() {
    Client clientExpected = FactoryClient.createClient(null,
            null,null,null,123123123,123123,123123,null);
    clientExpected.setId(clientExpected.getId()+1);

    Client clientActual = FactoryClient.createClient(null,
            null,null,null,123123123,123123,123123,null);

    assertEquals(clientExpected,clientActual,"Fields didn't match");
  }
}