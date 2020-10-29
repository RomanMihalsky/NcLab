package com.nc.mihalsky.entities.persons;

import org.joda.time.LocalDate;
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
    void getDateOfBirthDay() throws NoSuchFieldException, IllegalAccessException {
        Field field = client.getClass().getDeclaredField("dateOfBirthDay");
        field.setAccessible(true);
        LocalDate date = new LocalDate(1972,1,1);
        field.set(client,date);

        LocalDate result = client.getDateOfBirthDay();

        assertEquals(new LocalDate(1972,1,1),result,"Fields didn't match");
    }

    @Test
    void setDateOfBirthDay() throws NoSuchFieldException, IllegalAccessException {
        client.setDateOfBirthDay(new LocalDate(1972,1,1));

        Field field = client.getClass().getDeclaredField("dateOfBirthDay");
        field.setAccessible(true);

        assertEquals(new LocalDate(1972,1,1),field.get(client),"Fields didn't match");
    }

    @Test
    void getAge(){
        client = new Client(
                1L,
                "Roman",
                "Mihalsky",
                "Alexandrovich",
                "men",
                2L,
                1,
                1,
                new LocalDate(1999,10,12));

        assertEquals(21,client.getAge().getYears(),"Fields didn't match");
    }

    @Test
    void testToString(){
       assertEquals("Client{id=0, " +
               "name='', surname='', " +
               "patronymic='', gender='', " +
               "phoneNumber=0', " +
               "dateOfBirthDay=1900-01-01}",client.toString(),
               "Fields didn't match");
    }

    @Test
    void testToStringWithSecondConstructor(){
        client = new Client(
                1L,
                null,
                null,
                null,
                null,
                2L,
                1,
                1,
                new LocalDate(2010,2,3));
        assertEquals("Client{id=1," +
                " name=''," +
                " surname=''," +
                " patronymic=''," +
                " gender=''," +
                " phoneNumber=2'," +
                " dateOfBirthDay=2010-02-03}",client.toString(),
                "Fields didn't match");
    }
}