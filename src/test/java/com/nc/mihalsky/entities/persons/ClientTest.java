package com.nc.mihalsky.entities.persons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private Client client;

    @BeforeEach
    void init () {
        client = new Client();
    }

    @Test
    void getId() throws NoSuchFieldException, IllegalAccessException {
        Field field = client.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(client,1L);

        long result = client.getId();

        assertEquals(1L,result,"Fields didn't match");
    }

    @Test
    void setId() throws NoSuchFieldException, IllegalAccessException {
        client.setId(1);

        Field field = client.getClass().getDeclaredField("id");
        field.setAccessible(true);

        assertEquals(1L,field.get(client),"Fields didn't match");
    }

    @Test
    void getName() throws NoSuchFieldException, IllegalAccessException {
        Field field = client.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(client,"Roman");

        String result = client.getName();

        assertEquals("Roman",result,"Fields didn't match");
    }

    @Test
    void setName() throws NoSuchFieldException, IllegalAccessException {
        client.setName("Roman");

        Field field = client.getClass().getDeclaredField("name");
        field.setAccessible(true);

        assertEquals("Roman",field.get(client),"Fields didn't match");
    }

    @Test
    void getSurname() throws NoSuchFieldException, IllegalAccessException {
        Field field = client.getClass().getDeclaredField("surname");
        field.setAccessible(true);
        field.set(client,"Mihalsky");

        String result = client.getSurname();

        assertEquals("Mihalsky",result,"Fields didn't match");
    }

    @Test
    void setSurname() throws NoSuchFieldException, IllegalAccessException {
        client.setSurname("Mihalsky");

        Field field = client.getClass().getDeclaredField("surname");
        field.setAccessible(true);

        assertEquals("Mihalsky",field.get(client),"Fields didn't match");
    }

    @Test
    void getPatronymic() throws NoSuchFieldException, IllegalAccessException {
        Field field = client.getClass().getDeclaredField("patronymic");
        field.setAccessible(true);
        field.set(client,"Alex");

        String result = client.getPatronymic();

        assertEquals("Alex",result,"Fields didn't match");
    }

    @Test
    void setPatronymic() throws NoSuchFieldException, IllegalAccessException {
        client.setPatronymic("Alex");

        Field field = client.getClass().getDeclaredField("patronymic");
        field.setAccessible(true);

        assertEquals("Alex",field.get(client),"Fields didn't match");
    }

    @Test
    void getGender() throws NoSuchFieldException, IllegalAccessException {
        Field field = client.getClass().getDeclaredField("gender");
        field.setAccessible(true);
        field.set(client,"men");

        String result = client.getGender();

        assertEquals("men",result,"Fields didn't match");
    }

    @Test
    void setGender() throws NoSuchFieldException, IllegalAccessException {
        client.setGender("men");

        Field field = client.getClass().getDeclaredField("gender");
        field.setAccessible(true);

        assertEquals("men",field.get(client),"Fields didn't match");
    }

    @Test
    void getPhoneNumber() throws NoSuchFieldException, IllegalAccessException {
        Field field = client.getClass().getDeclaredField("phoneNumber");
        field.setAccessible(true);
        field.set(client,89301234523L);

        long result = client.getPhoneNumber();

        assertEquals(89301234523L,result,"Fields didn't match");
    }

    @Test
    void setPhoneNumber() throws NoSuchFieldException, IllegalAccessException {
        client.setPhoneNumber(89121232122L);

        Field field = client.getClass().getDeclaredField("phoneNumber");
        field.setAccessible(true);

        assertEquals(89121232122L,field.get(client),"Fields didn't match");
    }

    @Test
    void getPassportSeries() throws NoSuchFieldException, IllegalAccessException {
        Field field = client.getClass().getDeclaredField("passportSeries");
        field.setAccessible(true);
        field.set(client,1010);

        int result = client.getPassportSeries();

        assertEquals(1010,result,"Fields didn't match");
    }

    @Test
    void setPassportSeries() throws NoSuchFieldException, IllegalAccessException {
        client.setPassportSeries(1010);

        Field field = client.getClass().getDeclaredField("passportSeries");
        field.setAccessible(true);

        assertEquals(1010,field.get(client),"Fields didn't match");
    }

    @Test
    void getPassportNumber() throws NoSuchFieldException, IllegalAccessException {
        Field field = client.getClass().getDeclaredField("passportNumber");
        field.setAccessible(true);
        field.set(client,123456);

        int result = client.getPassportNumber();

        assertEquals(123456,result,"Fields didn't match");
    }

    @Test
    void setPassportNumber() throws NoSuchFieldException, IllegalAccessException {
        client.setPassportNumber(123456);

        Field field = client.getClass().getDeclaredField("passportNumber");
        field.setAccessible(true);

        assertEquals(123456,field.get(client),"Fields didn't match");
    }

    @Test
    void testToString(){
       assertEquals("Client{id=0, name='Ivan', surname='Ivanovich', patronymic='null', gender='men', phoneNumber=0}",client.toString(),"Fields didn't match");
    }
}