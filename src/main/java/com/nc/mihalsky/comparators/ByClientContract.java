package com.nc.mihalsky.comparators;

import com.nc.mihalsky.entities.contracts.Contract;

import java.util.Comparator;

public class ByClientContract implements Comparator<Contract> {
  @Override
  public int compare(Contract o1, Contract o2) {
    if(o1.getClient().compareTo(o2.getClient()) == 1 ){
      return 1;
    }else if(o1.getClient().compareTo(o2.getClient()) == -1){
      return -1;
    }else {
      return 0;
    }
  }
}
