package com.nc.mihalsky.entities.contracts.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternetTariffTest {
  InternetTariff internetTariff;

  @BeforeEach
  void init(){
    internetTariff = InternetTariff.MEGAS;
  }

  @Test
  void getInternetSpeed() {
    assertEquals(75,internetTariff.getInternetSpeed(),"Fields didn't match");
  }

  @Test
  void testToString() {
    assertEquals(
            "InternetTariff{internetSpeed=75}",
            internetTariff.toString(),
            "Fields didn't match");
  }
}