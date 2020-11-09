package com.nc.mihalsky.sorters;

import com.nc.mihalsky.entities.contracts.Contract;

import java.util.Comparator;

public interface Sorter <E extends Contract> {
  public void sort(Object[] values, Comparator<E> c);
}
