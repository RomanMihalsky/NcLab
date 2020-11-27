package com.nc.mihalsky.openers.creators;

import com.nc.mihalsky.entities.contracts.enums.InternetTariff;
import com.nc.mihalsky.entities.contracts.enums.MobileTariff;
import com.nc.mihalsky.entities.contracts.enums.TvTariff;
import com.nc.mihalsky.openers.CsvOpener;
import com.nc.mihalsky.openers.patterns.TitlePattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChooserTariffTest {
  CsvOpener csvOpener;
  ChooserTariff chooserTariff;
  String[] titles;
  TitlePattern[] patterns;
  String [] values1;
  String [] values2;
  String [] values3;
  HashMap<String,TitlePattern> mapPatterns;

  @BeforeEach
  void init() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
    csvOpener = new CsvOpener();
    values1 = new String[]{
            "10.05.2000","12.07.2007","internet","100","",
            "Roman","Mihalsky","Alex","man","12312312312","123123","1231","12.10.1999"};
    values2 = new String[]{
            "10.05.2000","12.07.2007","internet","20","100",
            "Roman","Mihalsky","Alex","man","12312312312","1232","2222","12.10.1999"};
    values3 = new String[]{
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

  }

  @Test
  void chooseInternetTariff() {
    InternetTariff result= ChooserTariff.chooseInternetTariff(values1,mapPatterns);
    assertEquals(InternetTariff.MEGAM,result,"Field's didn't match");
  }

  @Test
  void chooseMobileTariff() {
    MobileTariff result = ChooserTariff.chooseMobileTariff(values2,mapPatterns);
    assertEquals(MobileTariff.MEDIUM,result,"Field's didn't match");
  }

  @Test
  void chooseTvTariff() {
    TvTariff result = ChooserTariff.chooseTvTariff(values3,mapPatterns);
    assertEquals(TvTariff.SMALL,result,"Field's didn't match");
  }
}