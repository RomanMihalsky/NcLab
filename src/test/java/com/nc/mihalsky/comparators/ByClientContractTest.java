package com.nc.mihalsky.comparators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.factories.FactoryContract;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ByClientContractTest {

  ByClientContract byClientContract;
  FactoryContract factoryContract;
  Contract contract1;
  Contract contract2;

  @BeforeEach
  void init(){
    byClientContract = new ByClientContract();
    factoryContract = new FactoryContract();
    contract1 = factoryContract.createInternetContract();
    contract2 = factoryContract.createMobileContract();
  }

  @Test
  void compare() {
    int actual = byClientContract.compare(contract1,contract2);
    assertEquals(-1,actual,"Field's didn't match");

    actual = byClientContract.compare(contract2,contract1);
    assertEquals(1,actual,"Field's didn't match");

    contract1.getClient().setId(1);
    contract2.getClient().setId(1);
    actual = byClientContract.compare(contract1,contract2);
    assertEquals(0,actual,"Field's didn't match");
  }
}