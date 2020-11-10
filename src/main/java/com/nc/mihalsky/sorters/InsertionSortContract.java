package com.nc.mihalsky.sorters;

import com.nc.mihalsky.entities.contracts.Contract;

import java.util.Comparator;

public class InsertionSortContract <E extends Contract> implements Sorter<E>{
  /**Сортирует массив values методом вставок*/
  @Override
  public void sort(Object[] values, Comparator<E> c) {
    for (int i = 1; i < values.length; i++) {
      E current = (E)values[i];
      int j = i - 1;
      while(j >= 0 && (c.compare(current,(E)values[j]) == -1)) {
        values[j+1] = values[j];
        j--;
      }
      values[j+1] = current;
    }
  }
}

