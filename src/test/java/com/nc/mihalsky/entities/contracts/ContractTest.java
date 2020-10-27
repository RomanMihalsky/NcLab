package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.persons.Client;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ContractTest {
    Contract contract;

    @BeforeEach
    void init () {
        contract = new Contract() {
            @Override
            public String toString() {
                Client client = new Client();

                return "$classname{" +
                        "id=" + id +
                        ", dateStartOfUse=" + dateStartOfUse +
                        ", dateEndOfUse=" + dateEndOfUse +
                        ", client=" + client.getId() +
                        '}';
            }
        };
    }

    @Test
    void getId(){
        contract.id = 1L;
        assertEquals(1L,contract.getId(),"Fields didn't match");
    }

    @Test
    void setId(){
        contract.setId(1L);
        assertEquals(1L,contract.id,"Fields didn't match");
    }

    @Test
    void getDateStartOfUse(){
        contract.dateStartOfUse = new LocalDate(2010,1,1);
        assertEquals(new LocalDate(2010,1,1),contract.getDateStartOfUse(),"Fields didn't match");
    }

    @Test
    void setDateStartOfUse(){
        contract.setDateStartOfUse(new LocalDate(1972,1,1));
        assertEquals(new LocalDate(1972,1,1),contract.dateStartOfUse,"Fields didn't match");
    }

    @Test
    void getDateEndOfUse(){
        contract.dateEndOfUse = new LocalDate(2010,1,1);
        assertEquals(new LocalDate(2010,1,1),contract.getDateEndOfUse(),"Fields didn't match");
    }

    @Test
    void setDateEndOfUse(){
        contract.setDateEndOfUse(new LocalDate(1972,1,1));
        assertEquals(new LocalDate(1972,1,1),contract.dateEndOfUse,"Fields didn't match");
    }

    @Test
    void getClient(){
        Client client = new Client();
        contract.client = client;
        assertEquals(client,contract.getClient(),"Fields didn't match");
    }

    @Test
    void setClient(){
        Client client = new Client();
        contract.setClient(client);
        assertEquals(client,contract.getClient(),"Fields didn't match");
    }

    @Test
    void testToString(){
        assertEquals(
                "$classname{id=0," +
                " dateStartOfUse=null," +
                " dateEndOfUse=null," +
                " client=0}",contract.toString(),
                "Fields didn't match");
    }
}