package com.nc.mihalsky.comparators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.factories.FactoryContract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ByIdContractComparatorTest {

  ByIdContractComparator byIdContractComparator;
  FactoryContract factoryContract;
  Contract contract1;
  Contract contract2;

  @BeforeEach
  void init(){
    byIdContractComparator = new ByIdContractComparator();
    factoryContract = new FactoryContract();
    contract1 = factoryContract.createInternetContract();
    contract2 = factoryContract.createMobileContract();
  }

  @Test
  void compare() {

    int actual = byIdContractComparator.compare(contract1,contract2);
    assertEquals(-1,actual,"Field's didn't match");

    actual = byIdContractComparator.compare(contract2,contract1);
    assertEquals(1,actual,"Field's didn't match");

    contract1.setId(2);
    actual = byIdContractComparator.compare(contract1,contract2);
    assertEquals(0,actual,"Field's didn't match");
  }
}