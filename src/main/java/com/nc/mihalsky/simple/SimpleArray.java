package com.nc.mihalsky.simple;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

public class SimpleArray<E> implements SimpleList<E> {

  private Object[] values;
  private int size;

  public SimpleArray(){
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
  public Optional<Boolean> delete(int index) {
    if((index<0) || (index>size)){
      return Optional.empty();
    }

    values[index] = null;
    values = Arrays.stream(values).filter(a -> a!=null).toArray();
    return Optional.of(true);
  }

  @Override
  public Optional<E> get(int index) {
    if((index<0) || (index>size)){
      return Optional.empty();
    }
    return Optional.of((E)values[index]);
  }

  @Override
  public Optional<Boolean> set(int index, E e) {
    if((index<0) || (index>size)){
      return Optional.empty();
    }
    values[index] = e;
    return Optional.of(true);
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
