package com.nc.mihalsky.sorters;

import com.nc.mihalsky.comparators.ByIdContractComparator;
import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.factories.FactoryContract;
import com.nc.mihalsky.simple.SimpleArrayContract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortContractTest {

  @BeforeEach
  void init(){
    BubbleSortContract<Contract> bubbleSortContract = new BubbleSortContract<>();
  }

  @Test
  void sort() throws NoSuchFieldException, IllegalAccessException {
    SimpleArrayContract<Contract> simpleArrayContract = new SimpleArrayContract<>();
    FactoryContract factoryContract = new FactoryContract();

    Contract contract1 = factoryContract.createInternetContract();
    Contract contract2 = factoryContract.createMobileContract();
    Contract contract3 = factoryContract.createTvContract();
    Contract [] contracts = {contract2,contract1,contract3};

    Field field = simpleArrayContract.getClass().getDeclaredField("values");
    field.setAccessible(true);
    field.set(simpleArrayContract,contracts);
    simpleArrayContract.bubbleSortBy(new ByIdContractComparator());

    Contract [] contractsExpected = {contract1,contract2,contract3};

    Object[] contractsActual = (Object[]) field.get(simpleArrayContract);
    assertEquals(contractsExpected[0],contractsActual[0],"Field's didn't match");
  }
}