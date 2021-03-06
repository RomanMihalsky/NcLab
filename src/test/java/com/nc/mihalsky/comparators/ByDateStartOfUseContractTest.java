package com.nc.mihalsky.comparators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.factories.FactoryContract;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ByDateStartOfUseContractTest {

  ByDateStartOfUseContract byDateStartOfUseContract;
  FactoryContract factoryContract;
  Contract contract1;
  Contract contract2;

  @BeforeEach
  void init(){
    byDateStartOfUseContract = new ByDateStartOfUseContract();
    factoryContract = new FactoryContract();
    contract1 = factoryContract.createInternetContract();
    contract2 = factoryContract.createMobileContract();
  }

  @Test
  void compare() {
    contract1.setDateStartOfUse(new LocalDate(1999,1,1));
    contract2.setDateStartOfUse(new LocalDate(2000,1,1));
    int actual = byDateStartOfUseContract.compare(contract1,contract2);
    assertEquals(-1,actual,"Field's didn't match");

    actual = byDateStartOfUseContract.compare(contract2,contract1);
    assertEquals(1,actual,"Field's didn't match");

    contract1.setDateStartOfUse(new LocalDate(2000,1,1));
    contract2.setDateStartOfUse(new LocalDate(2000,1,1));
    actual = byDateStartOfUseContract.compare(contract1,contract2);
    assertEquals(0,actual,"Field's didn't match");
  }
}