package com.nc.mihalsky.comparators;

import com.nc.mihalsky.entities.contracts.Contract;

import java.util.Comparator;

public class ByIdContractComparator implements Comparator<Contract> {
  @Override
  public int compare(Contract o1, Contract o2) {
    if(o1.getId() > o2.getId()){
      return 1;
    }else if(o1.getId() < o2.getId()){
      return -1;
    }else {
      return 0;
    }
  }
}
