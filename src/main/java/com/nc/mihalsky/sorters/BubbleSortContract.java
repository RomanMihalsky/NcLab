package com.nc.mihalsky.sorters;

import com.nc.mihalsky.entities.contracts.Contract;

import java.util.Comparator;

public class BubbleSortContract<E extends Contract> implements Sorter<E>{
  public void sort(Object[] values, Comparator<E> c){
    boolean sorted = false;
    E temp;
    while (!sorted) {
      sorted = true;
      for (int i = 0; i < values.length - 1; i++) {
        if (c.compare((E)values[i],(E)values[i+1]) == 1) {
          temp = (E)values[i];
          values[i] = values[i+1];
          values[i+1] = temp;
          sorted = false;
        }
      }
    }
  }
}
