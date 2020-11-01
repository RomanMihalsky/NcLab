package com.nc.mihalsky.factories;

import com.nc.mihalsky.entities.contracts.InternetContract;
import com.nc.mihalsky.entities.contracts.MobileContract;
import com.nc.mihalsky.entities.contracts.TvContract;
import com.nc.mihalsky.entities.contracts.enums.InternetTariff;
import com.nc.mihalsky.entities.contracts.enums.MobileTariff;
import com.nc.mihalsky.entities.contracts.enums.TvTariff;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryContractTest {
  FactoryContract factoryContract = new FactoryContract();

  @Test
  void createInternetContract() {
    InternetContract internetContractExpected = factoryContract.createInternetContract();
    internetContractExpected.setId(internetContractExpected.getId()+1);
    internetContractExpected.getClient().setId(internetContractExpected.getClient().getId()+1);

    InternetContract internetContractActual = factoryContract.createInternetContract();
    assertEquals(internetContractExpected,internetContractActual,"Fields didn't match");
  }

  @Test
  void testCreateInternetContract() {
    InternetContract internetContractExpected = factoryContract.createInternetContract(
            new LocalDate(2010,1,1),new LocalDate(2020,5,5),FactoryClient.createClient(), InternetTariff.MEGAS);
    internetContractExpected.setId(internetContractExpected.getId()+1);
    internetContractExpected.getClient().setId(internetContractExpected.getClient().getId()+1);

    InternetContract internetContractActual = factoryContract.createInternetContract(
            new LocalDate(2010,1,1),new LocalDate(2020,5,5),FactoryClient.createClient(), InternetTariff.MEGAS);
    assertEquals(internetContractExpected,internetContractActual,"Fields didn't match");
  }

  @Test
  void testCreateInternetContractWithNull() {
    InternetContract internetContractExpected = factoryContract.createInternetContract(
           null,null,null,null);
    internetContractExpected.setId(internetContractExpected.getId()+1);
    internetContractExpected.getClient().setId(internetContractExpected.getClient().getId()+1);

    InternetContract internetContractActual = factoryContract.createInternetContract(
            null,null,null,null);
    assertEquals(internetContractExpected,internetContractActual,"Fields didn't match");
  }

  @Test
  void createMobileContract() {
    MobileContract mobileContractExpected = factoryContract.createMobileContract();
    mobileContractExpected.setId(mobileContractExpected.getId()+1);
    mobileContractExpected.getClient().setId(mobileContractExpected.getClient().getId()+1);

    MobileContract mobileContractActual = factoryContract.createMobileContract();
    assertEquals(mobileContractExpected,mobileContractActual,"Fields didn't match");
  }

  @Test
  void testCreateMobileContract() {
    MobileContract mobileContractExpected = factoryContract.createMobileContract(
            new LocalDate(2010,1,1),new LocalDate(2020,5,5),FactoryClient.createClient(), MobileTariff.CHEAP);
    mobileContractExpected.setId(mobileContractExpected.getId()+1);
    mobileContractExpected.getClient().setId(mobileContractExpected.getClient().getId()+1);

    MobileContract mobileContractActual = factoryContract.createMobileContract(
            new LocalDate(2010,1,1),new LocalDate(2020,5,5),FactoryClient.createClient(), MobileTariff.CHEAP);
    assertEquals(mobileContractExpected,mobileContractActual,"Fields didn't match");
  }

  @Test
  void testCreateMobileContractWithNull() {
    MobileContract mobileContractExpected = factoryContract.createMobileContract(
            null,null,null,null);
    mobileContractExpected.setId(mobileContractExpected.getId()+1);
    mobileContractExpected.getClient().setId(mobileContractExpected.getClient().getId()+1);

    MobileContract mobileContractActual = factoryContract.createMobileContract(
            null,null,null,null);
    assertEquals(mobileContractExpected,mobileContractActual,"Fields didn't match");
  }

  @Test
  void createTvContract() {
    TvContract tvContractExpected = factoryContract.createTvContract();
    tvContractExpected.setId(tvContractExpected.getId()+1);
    tvContractExpected.getClient().setId(tvContractExpected.getClient().getId()+1);

    TvContract tvContractActual = factoryContract.createTvContract();
    assertEquals(tvContractExpected,tvContractActual,"Fields didn't match");
  }

  @Test
  void testCreateTvContract() {
    TvContract tvContractExpected = factoryContract.createTvContract(
            new LocalDate(2010,1,1),new LocalDate(2020,5,5),FactoryClient.createClient(), TvTariff.SMALL);
    tvContractExpected.setId(tvContractExpected.getId()+1);
    tvContractExpected.getClient().setId(tvContractExpected.getClient().getId()+1);

    TvContract tvContractActual = factoryContract.createTvContract(
            new LocalDate(2010,1,1),new LocalDate(2020,5,5),FactoryClient.createClient(), TvTariff.SMALL);
    assertEquals(tvContractExpected,tvContractActual,"Fields didn't match");
  }

  @Test
  void testCreateTvContractWithNull() {
    TvContract tvContractExpected = factoryContract.createTvContract(
            null,null,null,null);
    tvContractExpected.setId(tvContractExpected.getId()+1);
    tvContractExpected.getClient().setId(tvContractExpected.getClient().getId()+1);

    TvContract tvContractActual = factoryContract.createTvContract(
            null,null,null,null);
    assertEquals(tvContractExpected,tvContractActual,"Fields didn't match");
  }
}