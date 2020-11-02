package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.contracts.enums.MobileTariff;
import com.nc.mihalsky.entities.persons.Client;
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
    void testToString() throws NoSuchFieldException, IllegalAccessException {
        Field fieldTariff = mobileContract.getClass().getDeclaredField("tariff");
        fieldTariff.setAccessible(true);
        Field fieldId = Contract.class.getDeclaredField("id");
        fieldId.setAccessible(true);
        Field fieldDateStartOfUse = Contract.class.getDeclaredField("dateStartOfUse");
        fieldDateStartOfUse.setAccessible(true);
        Field fieldDateEndOfUse = Contract.class.getDeclaredField("dateEndOfUse");
        fieldDateEndOfUse.setAccessible(true);

        Field fieldClient = Contract.class.getDeclaredField("client");
        fieldClient.setAccessible(true);

        Field fieldClientId = ((Client)fieldClient.get(mobileContract)).getClass().getDeclaredField("id");
        fieldClientId.setAccessible(true);


        assertEquals("MobileContract{tariff="+fieldTariff.get(mobileContract)+"," +
                        " id="+ fieldId.get(mobileContract)+"," +
                        " dateStartOfUse="+ fieldDateStartOfUse.get(mobileContract) +"," +
                        " dateEndOfUse="+ fieldDateEndOfUse.get(mobileContract) +"," +
                        " client="+ fieldClientId.get(((Client)fieldClient.get(mobileContract))) +"}",
                mobileContract.toString(),
                "Fields didn't match");
    }
}