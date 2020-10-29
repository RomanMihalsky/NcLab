package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.contracts.enums.MobileTariff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class MobileContractTest {
    MobileContract mobileContract;

    @BeforeEach
    void init (){
        mobileContract = new MobileContract();
    }

    @Test
    void getTariff() throws NoSuchFieldException, IllegalAccessException{
        Field field = mobileContract.getClass().getDeclaredField("tariff");
        field.setAccessible(true);
        field.set(mobileContract, MobileTariff.CHEAP);

        MobileTariff result = mobileContract.getTariff();

        assertEquals(MobileTariff.CHEAP,result,"Fields didn't match");
    }

    @Test
    void setTariff() throws NoSuchFieldException, IllegalAccessException{
        mobileContract.setTariff(MobileTariff.CHEAP);

        Field field = mobileContract.getClass().getDeclaredField("tariff");
        field.setAccessible(true);

        assertEquals(MobileTariff.CHEAP,field.get(mobileContract),"Fields didn't match");
    }

    @Test
    void testToString() {
        assertEquals("MobileContract{" +
                "tariff=MobileTariff{gigabytes=4," +
                " smsAmount=15}," +
                " id=0, dateStartOfUse=1900-01-01," +
                " dateEndOfUse=1900-01-01, client=0}",
                mobileContract.toString(),
                "Fields didn't match");
    }
}