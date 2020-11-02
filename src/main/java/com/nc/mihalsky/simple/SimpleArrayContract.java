package com.nc.mihalsky.simple;

import com.nc.mihalsky.entities.contracts.Contract;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

public class SimpleArrayContract<E extends Contract> implements SimpleListContract<E>{

  private Object[] values;
  private int size;

  public SimpleArrayContract(){
    this.values = new Object [1];
  }

  @Override
  public boolean add(E e) {
    checkSize();
    values[size] = e;
    size++;
    return true;
  }

  private void checkSize() {
    if(size == values.length){
      changeSize();
    }
  }

  private void changeSize() {
    values = Arrays.copyOf(values,size+1);
  }

  @Override
  public Optional<Boolean> delete(long id) {
    for (int i = 0;i < values.length;i ++) {
      if (((E)values[i]).getId() == id) {
        values[i] = null;
        values = Arrays.stream(values).filter(a -> a!=null).toArray();
        return Optional.of(true);
      }
    }
    return Optional.empty();
  }

  @Override
  public Optional<E> get(long id) {
    for (int i = 0;i < values.length;i ++) {
      if (((E)values[i]).getId() == id) {
        return Optional.of((E)values[i]);
      }
    }
    return Optional.empty();
  }

  @Override
  public Optional<Boolean> set(long id, E e) {
    for (int i = 0;i < values.length;i ++) {
      if (((E)values[i]).getId() == id) {
        values[i] = e;
        return Optional.of(true);
      }
    }
    return Optional.empty();
  }

  @Override
  public int size() {
    return values.length;
  }

  @Override
  public Iterator<E> iterator() {
    return new ArrayIterator<>(values);
  }

  @Override
  public String toString() {
    return Arrays.toString(values);
  }
}
