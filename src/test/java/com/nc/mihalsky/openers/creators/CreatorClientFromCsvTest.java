package com.nc.mihalsky.openers.creators;

import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.factories.FactoryClient;
import com.nc.mihalsky.openers.CsvOpener;
import com.nc.mihalsky.openers.patterns.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreatorClientFromCsvTest {
  CsvOpener csvOpener;
  CreatorClientFromCsv creator;
  String[] titles;
  TitlePattern[] patterns;
  String [] values;
  String [] values2;
  HashMap<String,TitlePattern> mapPatterns;

  @BeforeEach
  void init() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
    csvOpener = new CsvOpener();
    values = new String[]{
            "10.05.2000","12.07.2007","internet","100","",
            "Roman","Mihalsky","Alex","man","12312312312","123123","1231","12.10.1999"};
    values2 = new String[]{
            "10.05.2000","12.07.2007","internet","100","",
            "Roman","Mihalsky","Alex","man","12312312312","1232","2222","12.10.1999"};

    Field fieldAllData = csvOpener.getClass().getDeclaredField("allData");
    fieldAllData.setAccessible(true);
    List<String []> allData = new ArrayList<>();
    titles = new String[]{
            "dateStartOfUse", "dateEndOfUse", "tariff",
            "condition1", "condition2", "name",
            "surname", "patronymic", "gender",
            "phoneNumber","passportSeries","passportNumber","dateOfBirthDay"};
    allData.add(titles);
    fieldAllData.set(csvOpener,allData);
    Method method = csvOpener.getClass().getDeclaredMethod("findPositions");
    method.setAccessible(true);
    method.invoke(csvOpener);

    Field fieldMapPatterns = csvOpener.getClass().getDeclaredField("mapPatterns");
    fieldMapPatterns.setAccessible(true);
    mapPatterns = (HashMap<String,TitlePattern>)fieldMapPatterns.get(csvOpener);


    creator = new CreatorClientFromCsv(mapPatterns);
  }

  @Test
  void createIfSizeNull() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
    Method methodCreate = creator.getClass().getDeclaredMethod("create",String[].class);
    methodCreate.setAccessible(true);
    Client client = (Client) methodCreate.invoke(creator, (Object) values);

    Field field = client.getClass().getDeclaredField("id");
    field.setAccessible(true);
    long result = (long) field.get(client);

    assertEquals(result,client.getId(),"Field's didn't match");
  }

  @Test
  void createIfSizeNotNull() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
    Method methodCreate = creator.getClass().getDeclaredMethod("create",String[].class);
    methodCreate.setAccessible(true);
    Client client = (Client) methodCreate.invoke(creator, (Object) values);
    Client client2 = (Client) methodCreate.invoke(creator, (Object) values2);

    Field field = client2.getClass().getDeclaredField("id");
    field.setAccessible(true);
    long expected = (long)field.get(client2);

    assertEquals(expected,client2.getId(),"Field's didn't match");
  }

  @Test
  void createIfClientAlreadyExist() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Method methodCreate = creator.getClass().getDeclaredMethod("create",String[].class);
    methodCreate.setAccessible(true);
    Client client = (Client) methodCreate.invoke(creator, (Object) values);
    Client client2 = (Client) methodCreate.invoke(creator, (Object) values2);
    Client client3 = (Client) methodCreate.invoke(creator, (Object) values);

    assertEquals(client.getId(),client3.getId(),"Field's didn't match");
  }
}