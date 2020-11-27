package com.nc.mihalsky.openers;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.openers.patterns.TitlePattern;
import com.nc.mihalsky.simple.SimpleArrayContract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvOpenerTest {
  CsvOpener csvOpener;

  @BeforeEach
  void init(){
    csvOpener = new CsvOpener();
  }

  @Test
  void readFileToSimpleList() {
    SimpleArrayContract<Contract> contracts = new SimpleArrayContract<>();
    contracts = csvOpener.readFileToSimpleList(CsvOpener.CSV_FILE_PATH);
    assertNotEquals(null,contracts,"Incorrect result");
  }

  @Test
  void fillUp() throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Field fieldAllData = csvOpener.getClass().getDeclaredField("allData");
    fieldAllData.setAccessible(true);
    List<String []> allData = new ArrayList<>();
    String[] titles = new String[]{
            "dateStartOfUse", "dateEndOfUse", "tariff",
            "condition1", "condition2", "name",
            "surname", "patronymic", "gender",
            "phoneNumber","passportSeries","passportNumber","dateOfBirthDay"};
    String [] values = new String[]{
            "10.05.2000","12.07.2007","internet","100","",
            "Roman","Mihalsky","Alex","man","12312312312","123123","1231","12.10.1999"};
    allData.add(titles);
    allData.add(values);

    fieldAllData.set(csvOpener,allData);

    Method methodFindPositions = csvOpener.getClass().getDeclaredMethod("findPositions");
    methodFindPositions.setAccessible(true);
    methodFindPositions.invoke(csvOpener);

    Method methodFillUp = csvOpener.getClass().getDeclaredMethod("fillUp");
    methodFillUp.setAccessible(true);
    SimpleArrayContract<Contract> contractsResult = (SimpleArrayContract<Contract>) methodFillUp.invoke(csvOpener);
    assertEquals("[InternetContract{tariff=InternetTariff{internetSpeed=100}," +
            " id=1, dateStartOfUse=2000-05-10, dateEndOfUse=2007-07-12, client=1}]",contractsResult.toString(),"Field's didn't match");
  }

  @Test
  void findPositions() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    Field fieldAllData = csvOpener.getClass().getDeclaredField("allData");
    fieldAllData.setAccessible(true);
    List<String []> allData = new ArrayList<>();
    String[] titles = new String[]{
            "dateStartOfUse", "dateEndOfUse", "tariff",
            "condition1", "condition2", "name",
            "surname", "patronymic", "gender",
            "phoneNumber","passportSeries","passportNumber","dateOfBirthDay"};
    allData.add(titles);
    fieldAllData.set(csvOpener,allData);
    Method method = csvOpener.getClass().getDeclaredMethod("findPositions");
    method.setAccessible(true);
    method.invoke(csvOpener);

    Field fieldPatterns = csvOpener.getClass().getDeclaredField("patterns");
    fieldPatterns.setAccessible(true);
    TitlePattern[] patterns = (TitlePattern[]) fieldPatterns.get(csvOpener);
    assertEquals(4,patterns[1].getIndexOfTitle());
  }

  @Test
  void readData() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
    Method method = csvOpener.getClass().getDeclaredMethod("readData", String.class);
    method.setAccessible(true);
    method.invoke(csvOpener,CsvOpener.CSV_FILE_PATH);
    Field fieldAllValues = csvOpener.getClass().getDeclaredField("allData");
    fieldAllValues.setAccessible(true);
    Object result = fieldAllValues.get(csvOpener);
    assertNotEquals(null,result,"Incorrect result");
  }

  @Test
  void getArrayOfValues() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    Field field = csvOpener.getClass().getDeclaredField("allData");
    field.setAccessible(true);
    List<String []> list = new ArrayList<>();
    String [] expected = new String[]{"hello"};
    list.add(expected);
    field.set(csvOpener,list);

    Method method = csvOpener.getClass().getDeclaredMethod("getArrayOfValues");
    method.setAccessible(true);
    String[][] result = (String[][])method.invoke(csvOpener);

    assertEquals("hello",result[0][0],"Field's didn't match");
  }
}