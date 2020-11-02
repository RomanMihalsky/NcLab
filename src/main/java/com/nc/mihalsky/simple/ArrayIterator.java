package com.nc.mihalsky.simple;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
  private int index = 0;
  private Object[] values;

  public ArrayIterator(Object[] values){
    this.values = values;
  }

  @Override
  public boolean hasNext() {
    return index < values.length;
  }

  @Override
  public E next() {
    return (E)values[index ++];
  }
}
