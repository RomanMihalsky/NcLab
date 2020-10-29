package com.nc.mihalsky.entities.contracts.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TvTariffTest {
  TvTariff tvTariff;

  @BeforeEach
  void init(){
    tvTariff = TvTariff.SMALL;
  }

  @Test
  void getChannelsAmount() {
    assertEquals(10,tvTariff.getChannelsAmount());
  }

  @Test
  void testToString() {
    assertEquals("TvTariff{channelsAmount=10}",
            tvTariff.toString(),
            "Fields didn't match");
  }
}