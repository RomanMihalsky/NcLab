package com.nc.mihalsky.simple;

import com.nc.mihalsky.comparators.ByDateStartOfUseContract;
import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.contracts.InternetContract;
import com.nc.mihalsky.entities.contracts.MobileContract;
import com.nc.mihalsky.entities.contracts.TvContract;
import com.nc.mihalsky.factories.FactoryContract;
import com.nc.mihalsky.predicates.PredicateConditionId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayContractTest {

  SimpleArrayContract<Contract> simpleArrayContract;
  FactoryContract factoryContract = new FactoryContract();

  @BeforeEach
  void init (){
    simpleArrayContract = new SimpleArrayContract<>();
  }

  @Test
  void add() throws NoSuchFieldException, IllegalAccessException {
    simpleArrayContract.add(factoryContract.createInternetContract());
    simpleArrayContract.add(factoryContract.createMobileContract());
    simpleArrayContract.add(factoryContract.createTvContract());

    Field field = simpleArrayContract.getClass().getDeclaredField("values");
    field.setAccessible(true);
    Object [] contracts = (Object[]) field.get(simpleArrayContract);

    assertEquals(simpleArrayContract.toString(), Arrays.toString(contracts),"Fields didn't match");
  }

  @Test
  void checkSize() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Method method = simpleArrayContract.getClass().getDeclaredMethod("checkSize");
    method.setAccessible(true);
    assertEquals(null,method.invoke(simpleArrayContract),"Fields didn't match");
  }

  @Test
  void changeSize() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    InternetContract internetContract = factoryContract.createInternetContract();
    MobileContract mobileContract = factoryContract.createMobileContract();
    TvContract tvContract = factoryContract.createTvContract();

    Object [] contractsExpected = {internetContract,mobileContract,tvContract};

    Field fieldContracts = simpleArrayContract.getClass().getDeclaredField("values");
    fieldContracts.setAccessible(true);
    fieldContracts.set(simpleArrayContract,contractsExpected);

    Field fieldSize = simpleArrayContract.getClass().getDeclaredField("size");
    fieldSize.setAccessible(true);
    int size = 3;
    fieldSize.set(simpleArrayContract,size);

    contractsExpected = Arrays.copyOf(contractsExpected,size+1);

    Method method = simpleArrayContract.getClass().getDeclaredMethod("changeSize");
    method.setAccessible(true);
    method.invoke(simpleArrayContract);

    assertEquals(Arrays.toString(contractsExpected),simpleArrayContract.toString(),"Fields didn't match");
  }

  @Test
  void delete() throws NoSuchFieldException, IllegalAccessException {
    InternetContract internetContract = factoryContract.createInternetContract();
    MobileContract mobileContract = factoryContract.createMobileContract();
    TvContract tvContract = factoryContract.createTvContract();

    Object [] contracts = {internetContract,mobileContract,tvContract};

    Field fieldContracts = simpleArrayContract.getClass().getDeclaredField("values");
    fieldContracts.setAccessible(true);
    fieldContracts.set(simpleArrayContract,contracts);

    Field fieldMobileContractID = Contract.class.getDeclaredField("id");
    fieldMobileContractID.setAccessible(true);
    simpleArrayContract.delete((long)fieldMobileContractID.get(mobileContract));

    Field field = simpleArrayContract.getClass().getDeclaredField("values");
    field.setAccessible(true);
    contracts = (Object[]) field.get(simpleArrayContract);

    assertEquals(simpleArrayContract.toString(), Arrays.toString(contracts),"Fields didn't match");
  }

  @Test
  void get() throws NoSuchFieldException, IllegalAccessException {
    InternetContract internetContract = factoryContract.createInternetContract();
    MobileContract mobileContract = factoryContract.createMobileContract();
    TvContract tvContract = factoryContract.createTvContract();

    Object [] contracts = {internetContract,mobileContract,tvContract};

    Field fieldContracts = simpleArrayContract.getClass().getDeclaredField("values");
    fieldContracts.setAccessible(true);
    fieldContracts.set(simpleArrayContract,contracts);

    Field fieldMobileContractID = Contract.class.getDeclaredField("id");
    fieldMobileContractID.setAccessible(true);

    Contract contractActual = simpleArrayContract.get((long)fieldMobileContractID.get(mobileContract)).get();

    assertEquals(mobileContract,contractActual,"Fields didn't match");
  }

  @Test
  void set() throws NoSuchFieldException, IllegalAccessException {
    InternetContract internetContract = factoryContract.createInternetContract();
    MobileContract mobileContract = factoryContract.createMobileContract();
    TvContract tvContract = factoryContract.createTvContract();

    Object [] contracts = {internetContract,mobileContract,tvContract};

    Field fieldContracts = simpleArrayContract.getClass().getDeclaredField("values");
    fieldContracts.setAccessible(true);
    fieldContracts.set(simpleArrayContract,contracts);

    Field fieldMobileContractID = Contract.class.getDeclaredField("id");
    fieldMobileContractID.setAccessible(true);

    simpleArrayContract.set(2,tvContract);

    Field field = simpleArrayContract.getClass().getDeclaredField("values");
    field.setAccessible(true);
    contracts = (Object[]) field.get(simpleArrayContract);

    assertEquals(simpleArrayContract.toString(), Arrays.toString(contracts),"Fields didn't match");
  }

  @Test
  void bubbleSortBy(){
    simpleArrayContract.bubbleSortBy(new ByDateStartOfUseContract());
  }

  @Test
  void insertionSortBy(){
    simpleArrayContract.insertionSortBy(new ByDateStartOfUseContract());
  }

  @Test
  void searchBy() throws NoSuchFieldException, IllegalAccessException {
    FactoryContract factoryContract = new FactoryContract();

    Contract contract1 = factoryContract.createInternetContract();
    Contract contract2 = factoryContract.createMobileContract();
    Contract contract3 = factoryContract.createTvContract();
    Contract [] contracts = {contract2,contract1,contract3};

    Field fieldValues = simpleArrayContract.getClass().getDeclaredField("values");
    fieldValues.setAccessible(true);
    fieldValues.set(simpleArrayContract,contracts);

    Field fieldContractId = Contract.class.getDeclaredField("id");
    fieldContractId.setAccessible(true);
    long id = (long)fieldContractId.get(contract1);

    PredicateConditionId predicateConditionId = new PredicateConditionId(id);

    SimpleArrayContract<Contract> actualSimpleArrayContract = simpleArrayContract.searchBy(predicateConditionId.idPredicate);
    Field fieldValuesActual = simpleArrayContract.getClass().getDeclaredField("values");
    fieldValuesActual.setAccessible(true);
    Object[] objects = (Object[]) fieldValuesActual.get(actualSimpleArrayContract);

    assertEquals(contract1,objects[0],"Field's didn't match");
  }

  @Test
  void size() throws NoSuchFieldException, IllegalAccessException {
    InternetContract internetContract = factoryContract.createInternetContract();
    MobileContract mobileContract = factoryContract.createMobileContract();
    TvContract tvContract = factoryContract.createTvContract();

    Object [] contracts = {internetContract,mobileContract,tvContract};

    Field fieldContracts = simpleArrayContract.getClass().getDeclaredField("values");
    fieldContracts.setAccessible(true);
    fieldContracts.set(simpleArrayContract,contracts);

    assertEquals(3,simpleArrayContract.size(),"Fields didn't match");
  }

  @Test
  void iterator() {
    Iterator iterator = simpleArrayContract.iterator();
    assertEquals(true,(ArrayIterator)iterator instanceof ArrayIterator ,"Fields didn't match");
  }

  @Test
  void testToString() throws NoSuchFieldException, IllegalAccessException {
    InternetContract internetContract = factoryContract.createInternetContract();
    MobileContract mobileContract = factoryContract.createMobileContract();
    TvContract tvContract = factoryContract.createTvContract();

    Object [] contracts = {internetContract,mobileContract,tvContract};

    Field fieldContracts = simpleArrayContract.getClass().getDeclaredField("values");
    fieldContracts.setAccessible(true);
    fieldContracts.set(simpleArrayContract,contracts);

    assertEquals(Arrays.toString(contracts),simpleArrayContract.toString(),"Fields didn't match");
  }
}