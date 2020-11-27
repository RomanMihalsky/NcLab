package com.nc.mihalsky.openers.creators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.contracts.InternetContract;
import com.nc.mihalsky.entities.contracts.MobileContract;
import com.nc.mihalsky.entities.contracts.TvContract;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.factories.FactoryClient;
import com.nc.mihalsky.openers.CsvOpener;
import com.nc.mihalsky.openers.patterns.TitlePattern;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreatorContractFromCsvTest {
  CsvOpener csvOpener;
  CreatorContractFromCsv creator;
  String[] titles;
  TitlePattern[] patterns;
  String [] values;
  String [] values2;
  String [] values3;
  String [] values4;
  HashMap<String,TitlePattern> mapPatterns;

  @BeforeEach
  void init() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
    csvOpener = new CsvOpener();
    values = new String[]{
            "10.05.2000","12.07.2007","internet","100","",
            "Roman","Mihalsky","Alex","man","12312312312","123123","1231","12.10.1999"};
    values2 = new String[]{
            "10.05.2000","12.07.2007","mobile","20","100",
            "Roman","Mihalsky","Alex","man","12312312312","1232","2222","12.10.1999"};

    values3 = new String[]{
            "10.05.2000","12.07.2007","tv","10","",
            "Roman","Mihalsky","Alex","man","12312312312","1232","2222","12.10.1999"};

    values4 = new String[]{
            "10.05.2000","12.07.2007","null","10","",
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


    creator = new CreatorContractFromCsv(mapPatterns);
  }

  @Test
  void create() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Method method = creator.getClass().getDeclaredMethod("create", String[].class, Client.class);
    method.setAccessible(true);
    Contract contract = (Contract) method.invoke(creator,values,FactoryClient.createClient());
    assertEquals(1,contract.getId(),"Field's didn't match");
  }

  @Test
  void createFullInternet() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
    Method method = creator.getClass().getDeclaredMethod("createFull", String[].class, LocalDate.class, LocalDate.class, Client.class);
    method.setAccessible(true);
    InternetContract internetContract = (InternetContract) method.invoke(creator,values,new LocalDate(2000,5,10),new LocalDate(2007,7,12),FactoryClient.createClient());
    assertNotEquals(null,internetContract,"Field's didn't match");
  }

  @Test
  void createFullMobile() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
    Method method = creator.getClass().getDeclaredMethod("createFull", String[].class, LocalDate.class, LocalDate.class, Client.class);
    method.setAccessible(true);
    MobileContract mobileContract = (MobileContract) method.invoke(creator,values2,new LocalDate(2000,5,10),new LocalDate(2007,7,12),FactoryClient.createClient());
    assertNotEquals(null,mobileContract,"Field's didn't match");
  }

  @Test
  void createFullTv() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
    Method method = creator.getClass().getDeclaredMethod("createFull", String[].class, LocalDate.class, LocalDate.class, Client.class);
    method.setAccessible(true);
    TvContract tvContract = (TvContract) method.invoke(creator,values3,new LocalDate(2000,5,10),new LocalDate(2007,7,12),FactoryClient.createClient());
    assertNotEquals(null,tvContract,"Field's didn't match");
  }
  @Test
  void createFullNull() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
    Method method = creator.getClass().getDeclaredMethod("createFull", String[].class, LocalDate.class, LocalDate.class, Client.class);
    method.setAccessible(true);
    TvContract tvContract = (TvContract) method.invoke(creator,values4,new LocalDate(2000,5,10),new LocalDate(2007,7,12),FactoryClient.createClient());
    assertEquals(null,tvContract,"Field's didn't match");
  }
}