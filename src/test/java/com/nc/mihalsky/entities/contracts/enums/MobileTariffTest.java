package com.nc.mihalsky.entities.contracts.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MobileTariffTest {

    MobileTariff tariff;

    @BeforeEach
    void init(){
        tariff = MobileTariff.CHEAP;
    }

    @Test
    void getGigabytes() {
        assertEquals(4,tariff.getGigabytes(),"Fields didn't match");
    }

    @Test
    void getSmsAmount() {
        assertEquals(15,tariff.getSmsAmount(),"Fields didn't match");
    }

    @Test
    void testToString() {
        assertEquals(
                "MobileTariff{gigabytes=4," +
                " smsAmount=15}",
                tariff.toString(),
                "Fields didn't match");
    }
}